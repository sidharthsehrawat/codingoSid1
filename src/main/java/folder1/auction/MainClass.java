package folder1.auction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass{
    public static void main(String[] args) {

        Subject maths1 = new Subject("maths", 100);
        Subject science1 = new Subject("science", 70);
        Subject english1 = new Subject("english", 80);
        Subject sanskrit1 = new Subject("sanskrit", 50);
        Student student1 = new Student("Athelstan", Arrays.asList(maths1, science1, english1, sanskrit1));


        Subject sst2 = new Subject("sst", 20);
        Subject science2 = new Subject("science", 50);
        Subject english2 = new Subject("english", 30);
        Subject hindi2 = new Subject("hindi", 12);
        Student student2 = new Student("Bob", Arrays.asList(sst2, science2, english2, hindi2));


        Subject sst3 = new Subject("sst", 15);
        Subject hindi3 = new Subject("hindi", 60);
        Subject french3 = new Subject("french", 90);
        Subject bio3 = new Subject("bio", 88);
        Student student3 = new Student("Cecil", Arrays.asList(sst3, hindi3, french3, bio3));


        Subject maths4 = new Subject("maths", 16);
        Subject agri4 = new Subject("agriculture", 60);
        Subject french4 = new Subject("french", 90);
        Subject sanskrit4 = new Subject("sanskrit", 88);
        Student student4 = new Student("Drew", Arrays.asList(maths4, agri4, french4, sanskrit4));


        List<Student> students = Arrays.asList(student1, student2, student3, student4);
       // students.stream().forEach(student -> System.out.println(student.getName()));
        //  List<?> sub = students.stream().flatMap(student -> student.getSubjects().stream()).map(Subject::getName).sorted().collect(Collectors.toList());
       // List<String> stu = students.stream().filter(student -> student.getName().equalsIgnoreCase("Bob")).flatMap(subject->subject.getSubjects().stream()).map(Subject::getName).collect(Collectors.toList());
       // System.out.println(stu);
        Map<String,List<Student>> m = new HashMap<>();
        Map<List<Subject>, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getSubjects));

        System.out.println(map);
    }
    }
