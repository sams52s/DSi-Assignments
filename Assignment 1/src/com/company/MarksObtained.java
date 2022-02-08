package com.company;

import java.util.HashMap;
import java.util.Objects;

public class MarksObtained {
    Filehandler filehandler=new Filehandler();
    private String roll,subjectCode,isTheory,isPractical,marksForTheory,marksForPractical;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }


    public void setIsTheory(String isTheory) {
        this.isTheory = isTheory;
    }


    public void setIsPractical(String isPractical) {
        this.isPractical = isPractical;
    }

    public String getMarksForTheory() {
        return marksForTheory;
    }

    public void setMarksForTheory(String marksForTheory) {
        this.marksForTheory = marksForTheory;
    }

    public String getMarksForPractical() {
        return marksForPractical;
    }

    public void setMarksForPractical(String marksForPractical) {
        this.marksForPractical = marksForPractical;
    }
    HashMap<String,int[][]>hashMark=new HashMap<>();

    public void getMarks(String roll){
        HashMap<Integer,String[]> marks=filehandler.fileReader("marks.csv");
        for(int i=1;i<=marks.size();i++){
            setRoll(marks.get(i)[0]);
            if(Objects.equals(getRoll(), roll)) {
                setSubjectCode(marks.get(i)[1]);
                setIsTheory(marks.get(i)[2]);
                setIsPractical(marks.get(i)[3]);
                setMarksForTheory(marks.get(i)[4]);
                setMarksForPractical(marks.get(i)[5]);
                int theory=Integer.parseInt(getMarksForTheory());
                int practical=Integer.parseInt(getMarksForPractical());
                int[][] arrMarks= new int[1][2];
                arrMarks[0][0]=theory;
                arrMarks[0][1]=practical;
                hashMark.put(getSubjectCode(),arrMarks);
            }
        }
    }
    public  HashMap<String,int[][]> marksMap(){
        return hashMark;
    }
}
