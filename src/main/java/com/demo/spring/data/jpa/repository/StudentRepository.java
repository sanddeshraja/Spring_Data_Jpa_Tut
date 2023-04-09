package com.demo.spring.data.jpa.repository;
import com.demo.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long > {
   public List<Student> findByFirstName(String firstName);

   public List<Student> findByFirstNameContaining(String name);

   public List<Student> findByGuardianName(String guardianName);

   //JPQL
   @Query("select s from Student s where s.emailId = ?1")
   public List<Student> getStudentByEmailAddress(String emailAddress);
//   or
//@Query(value ="select s from student where s.emailId = :emailAddress", nativeQuery = true)
//public List<Student> getStudentByEmailAddress(@Param("emailAddress") String emailAddress);
@Modifying
@Transactional
   @Query( value = "update student set first_name = ?1 where email_address = ?2 "
         ,nativeQuery = true)
   int updateStudentNameByEmailId(String firstName, String emailId);


}
