package com.demo.spring.data.jpa.repository;

import com.demo.spring.data.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;
    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
        PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                 PageRequest.of(0,2);

        List<Course> courses = courseRepository.findAll(firstPagewithThreeRecords).getContent();
    }
    @Test
    public void findALlSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc  = PageRequest.of(0,2, Sort.by("credit").descending().and(Sort.by("title")));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses ="+ courses);
    }

}