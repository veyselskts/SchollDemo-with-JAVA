package com.example.MVI.schoolDemo.Entities;


import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {

    public Student() {}
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="number")
    private int number;
    @Column(name="email")
    private String email;
    @Column(name="gsm_number")
    private Long gsmNumber;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Long getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(Long gsmNumber) {
        this.gsmNumber = gsmNumber;
    }
}
