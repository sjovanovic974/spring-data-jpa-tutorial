package com.example.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long teacherId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

  /* It works but preferable way is to set relationship on many sie
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private List<Course> courses;
   */
}
