package com.br.horasestudos.views.entity;

public class Discipline {
    private int id;
    private String name;
    private float hour;
    private String date;
    private long all_hours;



    //metodo que transforma os numeros do banco em horas
    public long changeToHour(){
        return getAll_hours() / 60;
    }
    //metodo que transforma os numeros do banco em minutos
    public long changeToMinute(){
        return getAll_hours() % 60;
    }

    public Discipline(){

    }

    public Discipline(int id, String name, float hour, String date, long all_hours) {
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

    public long getAll_hours() {
        return all_hours;
    }

    public void setAll_hours(long all_hours) {
        this.all_hours = all_hours;
    }
}
