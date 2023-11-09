package folder1.auction;

import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;



    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }



    public String getName() {
        return this.name;
    }



    public List<Subject> getSubjects() {
        return this.subjects;
    }



}
