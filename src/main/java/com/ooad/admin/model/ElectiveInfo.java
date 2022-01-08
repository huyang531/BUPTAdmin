package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="elective_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectiveInfo {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "teacher_teacher")
    private Teacher teacher;
    private String grade;
    private String year;
    private String time;
    @ManyToOne
    @JoinColumn(name = "classroom_room")
    private Classroom classroom;
    private int num;
    private int num_selected;
    private int status;
}
