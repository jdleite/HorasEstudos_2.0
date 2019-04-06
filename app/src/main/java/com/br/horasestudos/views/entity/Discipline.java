package com.br.horasestudos.views.entity;

public class Discipline {
    private int id;
    private String name;
    private float hour;
    private String date;
    private float all_hours;

    public Discipline(){

    }

    public Discipline(int id, String name, float hour, String date, float all_hours) {
        this.id = id;
        this.name = name;
        this.hour = hour;
        this.date = date;
        this.all_hours = all_hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getAll_hours() {
        return all_hours;
    }

    public void setAll_hours(float all_hours) {
        this.all_hours = all_hours;
    }
}
