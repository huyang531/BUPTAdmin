package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    //    定义主键id
    @Id
    @Column(name="sid")
    private String sid;

    @Column(name="name")
    private String name;

    @Column(name="sex")
    private String sex;

    @Column(name="province")
    private String province;

    @Column(name="ID")//命名有在特定情况下的时候可能会出现传入null值的问题，//// 这个时候需要改名或者添加 @JsonProperty(value = "ID") "
    @JsonProperty(value = "ID")
    private String ID;

    @Column(name="department")
    private String department;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student(String sid, String name, String sex, String province, String ID, String department) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.province = province;
        this.ID = ID;
        this.department = department;
    }

    public Student() {

    }



}
