package com.example.MVI.schoolDemo.Dtos;

public class StudentDto {
    private int id;
    private String fullName;
    private int number;
    private String email;
    private long gsmNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(long gsmNumber) {
        this.gsmNumber = gsmNumber;
    }
}
