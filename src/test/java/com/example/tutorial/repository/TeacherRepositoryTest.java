package com.example.tutorial.repository;

import com.example.tutorial.model.Course;
import com.example.tutorial.model.CourseMaterial;
import com.example.tutorial.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Edward")
                .lastName("Munson")
                .build();

        teacherRepository.save(teacher);
    }

}