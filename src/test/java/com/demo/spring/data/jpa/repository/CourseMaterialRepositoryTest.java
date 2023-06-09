package com.demo.spring.data.jpa.repository;

import com.demo.spring.data.jpa.entity.Course;
import com.demo.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;
    @Test
    public void  saveCourseMaterial()
    {
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial
                .builder().url("www.google.com")
                .course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }


}