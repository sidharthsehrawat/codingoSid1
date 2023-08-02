package folder.Oops.aggregation;

import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Institute {
    private String name;
    private Set<Department> departments;

    public Institute(String name,Set<Department> departments){
        this.departments=departments;
        this.name= name;
    }


    public void printTotalStudentsDepttWise(Institute institute) {
    // 1. Print all deptt names..
      //  institute.getDepartments().stream().forEach(department -> System.out.println(department.getName()));

    // 2. Print All student names..
       /* institute.getDepartments().stream().forEach(department -> { department.getStudents().stream().forEach(student -> {
            System.out.println(student.getStudentName());
        });});*/

       List<Department> s = institute.getDepartments().stream().collect(Collectors.toList());

        /*List<Student> dss=  s.stream().flatMap(student -> student.getStudents().stream()).sorted(new Comparator<Student>() {
             @Override
             public int compare(Student o1, Student o2) {
                 return o1.getStudentName().compareTo(o2.getStudentName());
             }
         }).collect(Collectors.toList());*/

    // 3. Print All Student names in ascending order....
       List<String> d=  institute.getDepartments().stream().flatMap(dp->dp.getStudents().stream()).map(Student::getStudentName).sorted().collect(Collectors.toList());
        System.out.println(d);


      /*  List<String> list = Arrays.asList("abc","def","lk","amb");
        List<String> s= list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
              return   o1.compareTo(o2);
            }
        }).collect(Collectors.toList());
        System.out.println(s);*/

       // List<Department> d=  institute.getDepartments().stream().collect(Collectors.toList());
       // List<Student> s = d.stream().map(de->de.getStudents()).collect(Collectors.toList());

        System.out.println(" =======");

        /*
         int count = (int) institute.getDepartments()
                .stream().mapToInt(dp->dp.getStudents()
                .size()).sum(); */

      /*   institute.getDepartments()
                .stream().flatMap(dp->dp.getStudents()
                        .stream()).map(Student::getStudentName).sorted().forEach(System.out::println);*/

      /*  institute.getDepartments()
                .stream().flatMap(dp->dp.getStudents().stream()).forEach(student -> {
                    System.out.println(student.getStudentName() + " " + student.getRollNo());
                });*/
         //List<Student> studentsList = departmentList.stream().collect(Collectors.toList());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
