package com.example.tutorial.repository;

import com.example.tutorial.model.Course;
import com.example.tutorial.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void saveCourse() {

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .build();

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .courseMaterial(courseMaterial)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses: " + courses);
    }
}