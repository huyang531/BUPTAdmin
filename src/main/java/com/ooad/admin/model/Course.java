package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="course")
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

    @OneToMany
    private Set<Student> studentlist = new HashSet<Student>();

    public Course() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Set<Student> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(Set<Student> studentlist) {
        this.studentlist = studentlist;
    }
}
