package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classroom")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Classroom {
    @JsonProperty("room")
    @Id
    @Column(name="room")
    private String room;

    @JsonProperty("place")
    @Column(name="place")
    private String place;

    @JsonProperty("free")
    @Column(name="free")
    private String free;
}

