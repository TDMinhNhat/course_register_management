package dev.skyherobrine.project.backend.models.postgresql;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @Table(name = "Departments")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", length = 150, nullable = false, unique = true) @NonNull
    private String courseName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false) @NonNull
    private Integer credits;

    @ManyToOne @JoinColumn(name = "department_id", nullable = false) @NonNull
    private Department department;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

    public Course(@NonNull String courseName, String description, @NonNull Integer credits, @NonNull Department department) {
        this.courseName = courseName;
        this.description = description;
        this.credits = credits;
        this.department = department;
    }
}
