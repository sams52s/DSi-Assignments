package com.company;

import java.io.*;
import java.util.*;

public class Filehandler {
    public static String writingPath="/home/dsi/work/DSi Assignment/Assignment 1/Output Files/";
    public static String readingPath="/home/dsi/work/DSi Assignment/Assignment 1/provided Files/";
    public HashMap<Integer,String[]> fileReader(String fileName){
        HashMap<Integer,String[]> fileContainer=new HashMap<>();
        String path=readingPath+fileName;
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(path));
            int i=1;
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");
                fileContainer.put(i,value);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContainer;
    }
    public static final String CSVFilePath = writingPath+"result.csv";
    List<List<String>> row = new ArrayList<>();
    public void writeResult(String roll,String name,String totalMark,String totalGrade){
        row.add(Arrays.asList(roll, name, totalMark, totalGrade));
        write(row);
    }
    public void write(List<List<String>> row){
        try (PrintWriter writer = new PrintWriter(CSVFilePath)) {
            for (List<String> rowData:row) {
                writer.append(String.join(":",rowData));
                writer.append("\n");
            }
            writer.close();
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static final String CSVFilePathForMarkSheet = writingPath+"mark_sheet.csv";
    List<List<String>> rowForMarkSheet = new ArrayList<>();
    public void writeResultForMarkSheet(String roll,String subjectCode,String totalMark,String totalGrade){
        rowForMarkSheet.add(Arrays.asList(roll, subjectCode, totalMark, totalGrade));
        writeForMarkSheet(rowForMarkSheet);
    }
    public void writeForMarkSheet(List<List<String>> row){
        try (PrintWriter writer = new PrintWriter(CSVFilePathForMarkSheet)) {
            for (List<String> rowData:row) {
                writer.append(String.join(":",rowData));
                writer.append("\n");
            }
            writer.close();
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
