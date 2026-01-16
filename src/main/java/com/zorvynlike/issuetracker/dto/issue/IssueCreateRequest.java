package com.zorvynlike.issuetracker.dto.issue;

import com.zorvynlike.issuetracker.domain.IssuePriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IssueCreateRequest {
    @NotBlank
    @Size(max = 200)
    private String title;

    @Size(max = 4000)
    private String description;

    @NotNull
    private IssuePriority priority;
}
