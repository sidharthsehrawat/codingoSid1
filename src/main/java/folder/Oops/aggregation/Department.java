package folder.Oops.aggregation;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private String name;

    public List<Student> students;

    public Department(String name , List<Student> students){
        this.name=name;
        this.students= students;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
