package folder.Oops.aggregation;

import lombok.Data;

import java.util.Comparator;

@Data
public class Student {
    private String studentName;
    private int rollNo;

    public Student(String studentName , int rollNo, String DepttName){
        this.studentName=studentName;
        this.rollNo= rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }



}
