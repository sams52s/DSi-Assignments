package com.sams.TeachingHome.student;

import javax.persistence.*;

@Entity
@Table
public class StudentModel {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String stander;
    private String subject;
    private String fee;

    public StudentModel() {
    }

    public StudentModel(Long id, String name, String stander, String subject, String fee) {
        this.id = id;
        this.name = name;
        this.stander = stander;
        this.subject = subject;
        this.fee = fee;
    }

    public StudentModel(String name, String stander, String subject, String fee) {
        this.name = name;
        this.stander = stander;
        this.subject = subject;
        this.fee = fee;
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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "studentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stander='" + stander + '\'' +
                ", subject='" + subject + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
