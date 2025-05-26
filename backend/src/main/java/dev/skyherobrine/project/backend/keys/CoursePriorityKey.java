package dev.skyherobrine.project.backend.keys;

import dev.skyherobrine.project.backend.models.postgresql.Course;
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
public class CoursePriorityKey implements Serializable {
    @ManyToOne @JoinColumn(name = "course_main_id", nullable = false)
    private Course courseMain;
    @ManyToOne @JoinColumn(name = "course_needed_id", nullable = false)
    private Course courseNeeded;
}
