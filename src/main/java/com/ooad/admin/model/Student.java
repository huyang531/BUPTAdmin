package com.ooad.admin.model;

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
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany(mappedBy = "studentlist", fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();
}
