package com.infoshareacademy.domain.parser;

public class Organizer {
    private int id;
    private String designation;


    public Organizer() {
    }

    public Organizer(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Organizator: " + designation ;
    }
}
