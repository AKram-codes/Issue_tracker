package com.zorvynlike.issuetracker.controller;

import com.zorvynlike.issuetracker.domain.IssuePriority;
import com.zorvynlike.issuetracker.domain.IssueStatus;
import com.zorvynlike.issuetracker.dto.issue.*;
import com.zorvynlike.issuetracker.service.IssueService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public IssueResponse create(@Valid @RequestBody IssueCreateRequest req, Authentication auth) {
        return issueService.createIssue(req, auth.getName());
    }

    @GetMapping
    public Page<IssueResponse> list(@RequestParam(required = false) IssueStatus status,
                                   @RequestParam(required = false) IssuePriority priority,
                                   @RequestParam(required = false) Long assignedToId,
                                   @RequestParam(required = false) String q,
                                   Pageable pageable) {
        return issueService.list(status, priority, assignedToId, q, pageable);
    }

    @GetMapping("/{id}")
    public IssueResponse get(@PathVariable Long id) {
        return issueService.get(id);
    }

    @PutMapping("/{id}")
    public IssueResponse update(@PathVariable Long id, @Valid @RequestBody IssueUpdateRequest req) {
        return issueService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        issueService.delete(id);
    }
}
