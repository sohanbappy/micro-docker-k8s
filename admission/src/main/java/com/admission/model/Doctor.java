package com.admission.model;

public class Doctor {
    private int id;
    private String name;
    private String phone;
    private String speciality;

    public Doctor(int id, String name, String phone, String speciality) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.speciality = speciality;
    }

    public Doctor(String name, String phone, String speciality) {
        this.name = name;
        this.phone = phone;
        this.speciality = speciality;
    }

    public Doctor() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
