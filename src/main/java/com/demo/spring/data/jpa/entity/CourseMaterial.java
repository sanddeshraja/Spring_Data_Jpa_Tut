package com.demo.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence"
            ,sequenceName = "course_material_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            ,generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;
    @OneToOne
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;

}
