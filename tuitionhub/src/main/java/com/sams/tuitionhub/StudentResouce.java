package com.sams.tuitionhub;

import com.sams.tuitionhub.model.Student;
import com.sams.tuitionhub.service.StudentSerevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentResouce {
    private final StudentSerevice studentSerevice;

    public StudentResouce(StudentSerevice studentSerevice) {
        this.studentSerevice = studentSerevice;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students=studentSerevice.findAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Student student=studentSerevice.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent=studentSerevice.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updateStudent=studentSerevice.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        studentSerevice.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
