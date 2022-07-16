package com.example.tutorial.repository;

import com.example.tutorial.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void printCourseMaterial() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println(courseMaterials);
    }

}