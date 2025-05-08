package folder.streams;

import folder.Oops.aggregation.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortListByStudentName {
    public static void main(String[] args) {
        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
        Arrays.sort(input);
        System.out.println(input);
        List<Student> list = new ArrayList<>();
        Student s1= new Student("sid",1,"d1");
        Student s2= new Student("Kid",3,"d2");
        Student s3= new Student("Mid",2,"d3");
        list.add(s1); list.add(s2); list.add(s3);


        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName()) ;
            }
        });

        System.out.println(list);
    }
}
