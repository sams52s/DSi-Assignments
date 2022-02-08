package com.company;

import java.util.HashMap;

public class Student {
    HashMap<String,String>studentInfo=new HashMap<>();
    Filehandler filehandler=new Filehandler();
    private String roll;
    private String name;

    public String getRoll() {
        return roll;
    }
    public void setRoll(String roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String,String> info(){
        HashMap<Integer,String[]> student_info=filehandler.fileReader("student_info.csv");
        for (int i=1;i<student_info.size();i++){
            setRoll(student_info.get(i)[0]);
            setName(student_info.get(i)[1]);
            studentInfo.put(getRoll(),getName());
        }
        return studentInfo;
    }
}
