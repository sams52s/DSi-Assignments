package com.company;

import java.util.*;
public class MargeResult{
    Filehandler filehandler=new Filehandler();
    HashMap<String,String[]> result=new HashMap<>();
    String[] grade=new String[2];
    String paperCode;
    int marks;

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    public void setGrade(String[] grade) {
        this.grade = grade;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public void marge(){
        String[] marge=new String[3];
        marge[0]=grade[0];
        marge[1]=grade[1];
        marge[2]=Integer.toString(marks);
        result.put(paperCode,marge);
    }

    public void show(String roll, String[] grade) {
        String grd="F";
        if(Objects.equals(grade[0], "T") && Objects.equals(grade[1], "T")){
            grd="T";
        }
        Paper paper=new Paper();
        HashMap<String,String>subjectPaperMap=paper.subjectPaper();
        filehandler.writeResultForMarkSheet(roll,subjectPaperMap.get(paperCode), String.valueOf(marks),grd);

    }
}
