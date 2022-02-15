package com.sams.TeachingHome.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public List<StudentModel> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentModel studentModel) {
        Optional<StudentModel> studentId = studentRepository.findStudentModelById(studentModel.getId());
        if (studentId.isPresent()){
            throw new IllegalStateException("ID is used");
        }
        studentRepository.save(studentModel);
    }

    public void deleteStudent(Long studentId) {
        boolean exists= studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id "+studentId+"does not exists"
            );
        }
        studentRepository.deleteById(studentId);

    }
    @Transactional
    public void updateStudent(Long studentId, String name, String stander, String fee) {
        StudentModel studentModel=studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with this Id"+ studentId+ "not exist"));
        if(name !=null && name.length() >2){
            studentModel.setName(name);
        }
        if(stander !=null && stander.length() >0){
            studentModel.setStander(stander);
        }
        if(fee !=null && fee.length() >0){
            studentModel.setFee(fee);
        }
    }
}
