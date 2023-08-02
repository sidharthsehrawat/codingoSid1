package folder.Oops.aggregation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AggregationMain {
    public static void main(String[] args) {
        Set<Department> departments = new HashSet<>();

        List<Student> csestudentList = new ArrayList<>();
        List<Student> ecestudentList = new ArrayList<>();
        List<Student> mestudentList = new ArrayList<>();
        Student student = new Student("Sid",1, "CSE");
        Student student2 = new Student("Ash",2, "CSE");

        Student student3 = new Student("ABC",1, "ECE");
        Student student4 = new Student("DEF",2, "ECE");

        Student student5 = new Student("SAM",1, "ME");
        Student student6 = new Student("ROX",2, "ME");
        csestudentList.add(student);
        csestudentList.add(student2);
        ecestudentList.add(student3);
        ecestudentList.add(student4);
        mestudentList.add(student5);
        mestudentList.add(student6);

        Department csedepartment = new Department("CSE",csestudentList);
        Department ecedepartment = new Department("ECE",ecestudentList);
        Department medepartment = new Department("ME",mestudentList);

        departments.add(csedepartment);
        departments.add(ecedepartment);
        departments.add(medepartment);

        Institute institute = new Institute("IIT",departments);
        institute.printTotalStudentsDepttWise(institute);

    }
}
