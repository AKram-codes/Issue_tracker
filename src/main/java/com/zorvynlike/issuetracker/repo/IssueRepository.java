package com.zorvynlike.issuetracker.repo;

import com.zorvynlike.issuetracker.domain.Issue;
import com.zorvynlike.issuetracker.domain.IssuePriority;
import com.zorvynlike.issuetracker.domain.IssueStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    @Query("""
        SELECT i FROM Issue i
        WHERE (:status IS NULL OR i.status = :status)
          AND (:priority IS NULL OR i.priority = :priority)
          AND (:assignedToId IS NULL OR i.assignedTo.id = :assignedToId)
          AND (:q IS NULL OR lower(i.title) LIKE lower(concat('%', :q, '%'))
                        OR lower(i.description) LIKE lower(concat('%', :q, '%')))
    """)
    Page<Issue> search(@Param("status") IssueStatus status,
                       @Param("priority") IssuePriority priority,
                       @Param("assignedToId") Long assignedToId,
                       @Param("q") String q,
                       Pageable pageable);
}
