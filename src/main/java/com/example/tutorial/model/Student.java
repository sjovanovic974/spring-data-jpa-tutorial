package com.example.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(name = "UK_student_email_address", columnNames = "email_address"),
        @UniqueConstraint(name = "UK_guardian_email_address", columnNames = "guardian_email")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long studentId;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
