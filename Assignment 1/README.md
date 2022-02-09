# Result-Processing
I have written a java program to process the results of an examination. There are three categories of files:      
Student information    
Subject and paper information    
Marks obtained  
Each student gives exams for three subjects—Math, Physics and Chemistry. Math has one paper, while Physics and Chemistry have two papers each. In each paper, there are two parts—theoretical and practical. I have tabulated the marks and produce student wise results.
# Rules for Passing
The student has to get at least 50% of the total marks of a portion to pass in that portion (theoretical or practical) The student has to pass in both portions to pass the subject If the subject has papers, the student has to pass in both papers The student has to pass in all 3 subjects to get a pass in the full exam
# File Formats
All input files are CSV files, but the field separator is a ":" (colon), instead of comma.
# How I have solved this.

*1.* I read paper related file in **_paper_** class and student **info** in **_student_** class by the help of **fileReader** function of _**Filehandler**_ \
class and then those information are order in a **`HashMap`**. \
*2.* By the help of some for **`loop`** I connect all necessary information and create the desired output. \
*3.* Finally I write my output by **writing** method of **_Filehandler_** class.

&#x2600;Key materials
>HashMap \
> 2D Array \
> Lists 
