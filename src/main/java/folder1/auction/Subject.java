package folder1.auction;

import lombok.Data;

@Data
public class Subject {
    private String name;
    private Integer marks;



    public Subject(String name, Integer marks) {
        this.name = name;
        this.marks = marks;
    }



    public String getName() {
        return this.name;
    }



    public Integer getMarks() {
        return this.marks;
    }
}
