package com.example.myapplication.model;

public class Employee {

    private String id;
    private String name;
    private String dob;
    private String degination;
    private String yoe;
    private String address;

    public Employee() {
    }

    public Employee(String id, String name, String dob, String degination, String yoe, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.degination = degination;
        this.yoe = yoe;
        this.address = address;
    }

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDegination() {
        return degination;
    }

    public void setDegination(String degination) {
        this.degination = degination;
    }

    public String getYoe() {
        return yoe;
    }

    public void setYoe(String yoe) {
        this.yoe = yoe;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
