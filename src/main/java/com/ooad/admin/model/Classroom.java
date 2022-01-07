package com.ooad.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classroom")
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

    public Classroom(String room, String place, String free) {
        this.room = room;
        this.place = place;
        this.free = free;
    }

    public Classroom() {

    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }
}
