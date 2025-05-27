package dev.skyherobrine.project.backend.keys;

import dev.skyherobrine.project.backend.models.postgresql.Course;
import dev.skyherobrine.project.backend.models.postgresql.Department;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CourseSemesterDepartmentKey implements Serializable {
    @Column(nullable = false)
    private Integer semester;

    @ManyToOne @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
