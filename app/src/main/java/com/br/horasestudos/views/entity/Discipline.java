package com.br.horasestudos.views.entity;

public class Discipline {
    private int id;
    private String name;
    private float hour;
    private String date;
    private float all_Hours;

    public Discipline(){

    }

    public Discipline(int id, String name, float hour, String date, float all_Hours) {
        this.id = id;
        this.name = name;
        this.hour = hour;
        this.date = date;
        this.all_Hours = all_Hours;
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

    public float getAll_Hours() {
        return all_Hours;
    }

    public void setAll_Hours(float all_Hours) {
        this.all_Hours = all_Hours;
    }
}
