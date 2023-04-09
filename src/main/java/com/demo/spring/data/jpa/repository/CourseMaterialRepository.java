package com.demo.spring.data.jpa.repository;

import com.demo.spring.data.jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
