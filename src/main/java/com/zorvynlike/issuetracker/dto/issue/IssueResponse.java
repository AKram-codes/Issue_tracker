package com.zorvynlike.issuetracker.dto.issue;

import com.zorvynlike.issuetracker.domain.IssuePriority;
import com.zorvynlike.issuetracker.domain.IssueStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class IssueResponse {
    private Long id;
    private String title;
    private String description;
    private IssuePriority priority;
    private IssueStatus status;

    private Long createdById;
    private String createdByEmail;

    private Long assignedToId;
    private String assignedToEmail;

    private Instant createdAt;
    private Instant updatedAt;
}
