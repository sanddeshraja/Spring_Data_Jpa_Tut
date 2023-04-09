package com.demo.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
@Id
@SequenceGenerator(sequenceName = "teacherId_sequence",name="teacherId_sequence",allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacherId_sequence")
    private  Long teacherId;
    private String firstName;
    private  String lastName;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="teacher_id",referencedColumnName = "teacherId")
    private List<Course> course;
}
