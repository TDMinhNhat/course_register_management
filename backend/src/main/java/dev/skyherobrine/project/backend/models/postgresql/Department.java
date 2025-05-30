package dev.skyherobrine.project.backend.models.postgresql;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @Table(name = "Departments")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true) @NonNull
    private String shortName;
    @Column(length = 200, nullable = false, unique = true) @NonNull
    private String fullName;
    @Column(nullable = false)
    private boolean status;
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = true;
    }
}
