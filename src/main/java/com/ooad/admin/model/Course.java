package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @JsonProperty("course")
    @Column(name="course")
    private String course;

    @JsonProperty("name")
    @Column(name="name")
    private String name;

    @JsonProperty("teacher")
    @Column(name="teacher")
    private String teacher;

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
    @OneToMany()
    @JoinColumn(name="studentlist")
    private List<Student> studentlist = new ArrayList<>();

}
