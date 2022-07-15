package com.example.tutorial.repository;

import com.example.tutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianNAme);

    // JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // JPQL
    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // Native
    @Query(value = "SELECT * FROM students s WHERE s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    // Native Named Param
    @Query(value = "SELECT * FROM students s WHERE s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
}
