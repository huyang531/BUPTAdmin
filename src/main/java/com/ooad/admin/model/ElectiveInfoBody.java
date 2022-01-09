package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
public class ElectiveInfoBody {
    private String id;
    private Teacher teacher;
    private String grade;
    private String year;
    private String time;
    private Classroom classroom;
    private int num;
    private int num_selected;
    private int status;
}
