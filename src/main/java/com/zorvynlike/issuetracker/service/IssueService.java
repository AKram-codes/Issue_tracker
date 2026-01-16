package com.zorvynlike.issuetracker.service;

import com.zorvynlike.issuetracker.domain.*;
import com.zorvynlike.issuetracker.dto.issue.*;
import com.zorvynlike.issuetracker.exception.ApiException;
import com.zorvynlike.issuetracker.repo.IssueRepository;
import com.zorvynlike.issuetracker.repo.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    public IssueService(IssueRepository issueRepository, UserRepository userRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    public IssueResponse createIssue(IssueCreateRequest req, String createdByEmail) {
        User creator = userRepository.findByEmail(createdByEmail)
                .orElseThrow(() -> new ApiException(HttpStatus.UNAUTHORIZED, "User not found"));

        Issue issue = Issue.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .priority(req.getPriority())
                .status(IssueStatus.OPEN)
                .createdBy(creator)
                .build();

        return toResponse(issueRepository.save(issue));
    }

    public Page<IssueResponse> list(IssueStatus status, IssuePriority priority, Long assignedToId, String q, Pageable pageable) {
        return issueRepository.search(status, priority, assignedToId, q, pageable).map(this::toResponse);
    }

    public IssueResponse get(Long id) {
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Issue not found"));
        return toResponse(issue);
    }

    public IssueResponse update(Long id, IssueUpdateRequest req) {
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Issue not found"));

        if (req.getTitle() != null) issue.setTitle(req.getTitle());
        if (req.getDescription() != null) issue.setDescription(req.getDescription());
        if (req.getPriority() != null) issue.setPriority(req.getPriority());
        if (req.getStatus() != null) issue.setStatus(req.getStatus());

        if (req.getAssignedToId() != null) {
            User assignee = userRepository.findById(req.getAssignedToId())
                    .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "Assigned user not found"));
            issue.setAssignedTo(assignee);
        }

        return toResponse(issueRepository.save(issue));
    }

    public void delete(Long id) {
        if (!issueRepository.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Issue not found"));
        }
        issueRepository.deleteById(id);
    }

    private IssueResponse toResponse(Issue issue) {
        return IssueResponse.builder()
                .id(issue.getId())
                .title(issue.getTitle())
                .description(issue.getDescription())
                .priority(issue.getPriority())
                .status(issue.getStatus())
                .createdById(issue.getCreatedBy().getId())
                .createdByEmail(issue.getCreatedBy().getEmail())
                .assignedToId(issue.getAssignedTo() == null ? null : issue.getAssignedTo().getId())
                .assignedToEmail(issue.getAssignedTo() == null ? null : issue.getAssignedTo().getEmail())
                .createdAt(issue.getCreatedAt())
                .updatedAt(issue.getUpdatedAt())
                .build();
    }
}
