package com.oopPlayground.tdd.RoomAccess;

public class Person {
    private String id;
    private String name;
    private DESIGNATION_TYPE designation;

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

    public DESIGNATION_TYPE getDesignation() {
        return designation;
    }

    public void setDesignation(DESIGNATION_TYPE designation) {
        this.designation = designation;
    }
}
