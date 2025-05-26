package dev.skyherobrine.project.backend.models.postgresql;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @Table(name = "UserRoles")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class UserRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", length = 100, nullable = false, unique = true) @NonNull
    private String roleName;

    @Column(length = 500)
    private String description;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
        this.isActive = true;
    }

    public UserRole(@NonNull String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
}
