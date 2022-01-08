package com.ooad.admin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="timetable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimetableItem {
    @Id
    private String id;
    private String startTime;
    private String endTime;
    private String week;
    @ManyToOne
    @JoinColumn(name = "course_course")
    private Course course;
}
