package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Paper {
    Filehandler filehandler=new Filehandler();
    HashMap<Integer,String[]> subjectName=filehandler.fileReader("subject_name.csv");
    HashMap<Integer,String[]> subjectPaper=filehandler.fileReader("subject_paper.csv");
    HashMap<Integer,String[]> paperInfo=filehandler.fileReader("paper_info.csv");
    String[]paperCode=new String[subjectPaper.size()];
    //TO manipulate all files related subject.....
    public HashMap<String,int[][]> paperSorting(){
        for (int i=1;i<=subjectName.size();i++){
            String subjectCode=subjectName.get(i)[0];
            for(int j=1;j<=subjectPaper.size();j++){
                if(Objects.equals(subjectPaper.get(j)[0], subjectCode)) {
                    paperCode[j-1] = subjectPaper.get(j)[1];
                }
            }
        }
        HashMap<String,int[][]>passMark=new HashMap<>();
        for (int i=1;i<=paperInfo.size();i++){
            if(Objects.equals(paperCode[i - 1], paperInfo.get(i)[0])){
               int theory=Integer.parseInt(paperInfo.get(i)[5])/2;
               int prectical=Integer.parseInt(paperInfo.get(i)[6])/2;
               int[][] passMarks= new int[1][2];
               passMarks[0][0]=theory;
               passMarks[0][1]=prectical;
               passMark.put(paperInfo.get(i)[0],passMarks);
            }
        }
        return passMark;
    }
    HashMap<String,String>subjectPaperMap=new HashMap<>();
    public HashMap<String,String> subjectPaper(){
        for(int i=1;i<=subjectPaper.size();i++){
            subjectPaperMap.put(subjectPaper.get(i)[1],subjectPaper.get(i)[0]);
        }
        return subjectPaperMap;
    }
}
