package com.example.tutorial.repository;

import com.example.tutorial.model.Guardian;
import com.example.tutorial.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("alex.kowalsky@gmail.com")
                .firstName("Alex")
                .lastName("Kowalsky")
//                .guardianEmail("mary.leigh@gmail.com")
//                .guardianName("Mary Leigh")
//                .guardianMobile("068/521-47-54")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Mary Leigh")
                .email("mary.leigh@gmail.com")
                .mobile("068/521-47-54")
                .build();

        Student student = Student.builder()
                .firstName("Joe")
                .lastName("Buffet")
                .emailId("joe.buffet@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        studentList.forEach(System.out::println);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Joe");
        System.out.println("Students: " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("J");
        System.out.println("Students: " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Mary Leigh");
        System.out.println("Students: " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("joe.buffet@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("joe.buffet@gmail.com");
        System.out.println(studentName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("joe.buffet@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("joe.buffet@gmail.com");
        System.out.println(student);
    }
}