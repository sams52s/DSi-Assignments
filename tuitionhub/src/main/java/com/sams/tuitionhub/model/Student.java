package com.sams.tuitionhub.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String stander;
    private String subject;
    private String free;
    private String imageUrl;

    public Student() {
    }

    public Student(Long id, String name, String email, String stander, String subject, String free, String imageUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.stander = stander;
        this.subject = subject;
        this.free = free;
        this.imageUrl = imageUrl;
    }

    public Student(String name, String email, String stander, String subject, String free, String imageUrl) {
        this.name = name;
        this.email = email;
        this.stander = stander;
        this.subject = subject;
        this.free = free;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStander() {
        return stander;
    }

    public void setStander(String stander) {
        this.stander = stander;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", stander='" + stander + '\'' +
                ", subject='" + subject + '\'' +
                ", free='" + free + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public void setStudentCode(String toString) {
    }
}
