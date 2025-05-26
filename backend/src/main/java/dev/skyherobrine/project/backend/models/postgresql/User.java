package dev.skyherobrine.project.backend.models.postgresql;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.skyherobrine.project.backend.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "Users")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false) @NonNull
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false) @NonNull
    private String lastName;

    @Column(nullable = false) @NonNull
    private Boolean sex;

    @Column(name = "birth_date", nullable = false) @NonNull
    private LocalDate birthDate;

    @Column(length = 300)
    private String address;

    @Column(length = 25, nullable = false, unique = true) @NonNull
    private String phone;

    @Column(length = 200, nullable = false) @NonNull
    private String email;

    @Column(length = 100, nullable = false) @NonNull
    private String password;

    @ManyToOne @JoinColumn(name = "department_id", nullable = false) @NonNull
    private Department department;

    @ManyToOne @JoinColumn(name = "role_id", nullable = false) @NonNull
    private UserRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
        this.status = UserStatus.ACTIVATED;
    }
}
