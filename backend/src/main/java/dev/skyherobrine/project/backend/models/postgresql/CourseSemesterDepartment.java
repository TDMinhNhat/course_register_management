package dev.skyherobrine.project.backend.models.postgresql;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.skyherobrine.project.backend.keys.CourseSemesterDepartmentKey;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @Table(name = "CourseSemesterDepartments")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class CourseSemesterDepartment {

    @EmbeddedId @NonNull
    private CourseSemesterDepartmentKey id;

    @Column(nullable = false) @NonNull
    private Boolean optional;

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
