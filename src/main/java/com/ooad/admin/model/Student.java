package com.ooad.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    //    定义主键id
    @Id
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="year")
    private String year;

    public Student() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Student(String id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

}
