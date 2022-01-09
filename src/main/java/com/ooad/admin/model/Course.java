package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"studentlist"})
public class Course {

    @Id
    @JsonProperty("course")
    @Column(name="course")
    private String course;

    @JsonProperty("name")
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_teacher")
    private Teacher teacher;

    @JsonProperty("credit")
    @Column(name="credit")
    private String credit;

    @JsonProperty("department")
    @Column(name="department")
    private String department;

    @JsonProperty("day")
    @Column(name="day")
    private String day;

    @JsonProperty("studentlist")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_takes_course",
            joinColumns = @JoinColumn(name = "student_sid"),
            inverseJoinColumns = @JoinColumn(name = "course_course")
    )
    private Set<Student> studentlist = new HashSet<>();
}
