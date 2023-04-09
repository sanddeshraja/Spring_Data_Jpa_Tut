package com.demo.spring.data.jpa.repository;

import com.demo.spring.data.jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
