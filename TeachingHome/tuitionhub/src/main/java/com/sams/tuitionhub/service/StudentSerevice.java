package com.sams.tuitionhub.service;

import com.sams.tuitionhub.exception.UserNotFoundException;
import com.sams.tuitionhub.model.Student;
import com.sams.tuitionhub.repository.StudentRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentSerevice {
    private final StudentRepostory studentRepostory;
    @Autowired
    public StudentSerevice(StudentRepostory studentRepostory) {
        this.studentRepostory = studentRepostory;
    }
    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepostory.save(student);
    }
    public List<Student> findAllStudent(){
        return studentRepostory.findAll();
    }
    public Student updateStudent(Student student){
        return studentRepostory.save(student);
    }
    public Student findStudentById(Long id){
        return studentRepostory.findStudentById(id).orElseThrow(()-> new UserNotFoundException("User by id "+ id +" not found"));
    }
    public void deleteStudent(Long id){
         studentRepostory.deleteStudentById(id);
    }


}
