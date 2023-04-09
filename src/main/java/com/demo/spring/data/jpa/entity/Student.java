package com.demo.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//table tag to map this class to the respective table
//@Table(name="tbl_student",   uniqueConstraints =  @UniqueConstraint(name = "emailid_unique",
//        columnNames = "email_address" ))
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",
                        sequenceName = "student_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
   @Column(name="email_address"
           ,nullable = false) //Column Name to be displayed irrespective of the var name
    private String  emailId;
   @Embedded
  private Guardian guardian;
}
