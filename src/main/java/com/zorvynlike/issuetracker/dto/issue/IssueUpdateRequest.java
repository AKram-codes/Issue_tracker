package com.zorvynlike.issuetracker.dto.issue;

import com.zorvynlike.issuetracker.domain.IssuePriority;
import com.zorvynlike.issuetracker.domain.IssueStatus;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IssueUpdateRequest {
    @Size(max = 200)
    private String title;

    @Size(max = 4000)
    private String description;

    private IssuePriority priority;
    private IssueStatus status;
    private Long assignedToId;
}
