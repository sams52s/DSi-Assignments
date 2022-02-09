package com.company;

import java.util.*;

public class Resultantly {
    Filehandler filehandler=new Filehandler();
    MargeResult mr=new MargeResult();
    Student student=new Student();
    MarksObtained marksObtained=new MarksObtained();
    String roll,name;
    public void student(){
        HashMap<String,String>studentInfo=student.info();
        String[] keySet=studentInfo.keySet().toArray(new String[studentInfo.size()]);
        String[] NameSet=studentInfo.values().toArray(new String[studentInfo.size()]);
        for (int i=0;i<keySet.length;i++) {
            roll=keySet[i];
            marksObtained.getMarks(keySet[i]);
            name=NameSet[i];
            compare();
        }
    }
    public void compare(){
        Paper paper=new Paper();
        HashMap<String,int[][]>passMark=paper.paperSorting();
        HashMap<String,int[][]>hashMark= marksObtained.marksMap();
        int totalMark=0;
        String totalGrade=null;
        String[] grade=new String[2];
        for (int i=0;i<paper.paperCode.length;i++){
            int subMark=0;
            mr.setPaperCode(paper.paperCode[i]);
            for (int j=0;j<2;j++) {
                if (passMark.get(paper.paperCode[i])[0][j]>hashMark.get(paper.paperCode[i])[0][j]){
                    grade[j]="F";
                    totalGrade="F";
                }
                else {
                    grade[j]="T";
                    if(totalGrade==null|| totalGrade.equals("T")){
                        totalGrade="T";
                    }
                }
                totalMark+=hashMark.get(paper.paperCode[i])[0][j];
                subMark+=hashMark.get(paper.paperCode[i])[0][j];
                mr.setGrade(grade);
            }
            mr.setMarks(subMark);
            mr.marge();
            mr.show(roll,grade);
        }
        filehandler.writeResult(roll,name,Integer.toString(totalMark),totalGrade);
    }
}
