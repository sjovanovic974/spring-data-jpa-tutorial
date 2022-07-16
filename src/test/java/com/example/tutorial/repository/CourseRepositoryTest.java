package com.example.tutorial.repository;

import com.example.tutorial.model.Course;
import com.example.tutorial.model.CourseMaterial;
import com.example.tutorial.model.Teacher;
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
    private CourseRepository courseRepository;

    private static void printCourses(List<Course> courses) {
        courses.forEach(course -> {
            System.out.println("--------------------------------------");
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Course Title: " + course.getTitle());
            System.out.println("Course Credit: " + course.getCredit());
            System.out.println("Course Material URL: " + course.getCourseMaterial().getUrl());
            System.out.println("Course Teacher: " +
                    (course.getTeacher() != null ? course.getTeacher().getFirstName() + " " +
                            course.getTeacher().getLastName() : "Not Assigned"));
            System.out.println("--------------------------------------");
        });
    }


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
    public void saveALlCourses() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.somepage.com")
                .build();

        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .courseMaterial(courseMaterial)
                .build();

        CourseMaterial courseMaterialJava = CourseMaterial.builder()
                .url("www.javapages.com")
                .build();

        Course courseJava = Course.builder()
                .title("JAVA")
                .credit(15)
                .courseMaterial(courseMaterialJava)
                .build();

        courseRepository.saveAll(List.of(course, courseJava));
    }


    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Mary")
                .lastName("Smith")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.blablabla.com")
                .build();

        Course course = Course.builder()
                .title("CET")
                .credit(5)
                .teacher(teacher)
                .courseMaterial(courseMaterial)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();

        printCourses(courses);
    }


    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalELements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        Integer totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Total elements: " + totalELements);
        System.out.println("Total pages: " + totalPages);

        printCourses(courses);
    }

    @Test
    public void findAllSorting() {

        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));

        Pageable sortByCreditDescending = PageRequest.of(0, 3, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDescending = PageRequest.of(
                0,
                3,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit")
                                .descending())

        );

        List<Course> courses = courseRepository.findAll(sortByCreditDescending).getContent();

        printCourses(courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();

        printCourses(courses);
    }
}