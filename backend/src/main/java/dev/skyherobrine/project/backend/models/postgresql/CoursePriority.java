package dev.skyherobrine.project.backend.models.postgresql;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.skyherobrine.project.backend.keys.CoursePriorityKey;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @Table(name = "CoursePriorities")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class CoursePriority {

    @EmbeddedId @NonNull
    private CoursePriorityKey id;

    @Column(length = 1000)
    private String description;

    @ManyToOne @JoinColumn(name = "department_id", nullable = false) @NonNull
    private Department department;

    @Column(nullable = false)
    private boolean status;

    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
        this.status = true;
    }
}
