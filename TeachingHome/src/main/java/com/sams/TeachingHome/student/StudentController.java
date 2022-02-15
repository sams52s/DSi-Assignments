package com.sams.TeachingHome.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/th")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel>getStudent(){
        return studentService.getStudent();
    }
    @PatchMapping
    public void registerNewStudent(@RequestBody StudentModel studentModel){
        studentService.addNewStudent(studentModel);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId")Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String stander,
            @RequestParam(required = false) String fee){
        studentService.updateStudent(studentId,name,stander,fee);
    }
}
