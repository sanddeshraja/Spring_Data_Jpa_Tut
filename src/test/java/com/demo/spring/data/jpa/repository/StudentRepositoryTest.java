package com.demo.spring.data.jpa.repository;

import com.demo.spring.data.jpa.entity.Guardian;
import com.demo.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@DataJpaTest to not impact the Db will testing
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student
                .builder()
                .emailId("xyz@gmail.com")
                .firstName("Abc")
                .lastName("abc")
//                .guardianName("MNO")
//                .guardianEmail("tuv@gmail.com")
//                .guardianMobile("1234567890")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Boot")
                .email("Boots@gmail.com")
                .mobile("0987654321")
                .build();
        Student student = Student.builder()
                .firstName("Shoe")
                .emailId("Shoe@woo.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList = "+ studentList);
    }

    @Test
    public void printStudentByFirstName(){
       List<Student> studentList= studentRepository.findByFirstName("Shoe");
        System.out.println("Students ="+ studentList);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Sh");
        System.out.println("Students Containing"+ students);
    }
    @Test
    public void printStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("MNO");
        System.out.println("Students Containing Guardian"+ students);
    }
}