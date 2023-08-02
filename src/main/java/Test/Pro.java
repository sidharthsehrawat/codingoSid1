package Test;

import java.util.*;
import java.util.stream.Stream;

public class Pro {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Sid", 20);
        map.put("Ashish", 10);
        map.put("Adam", 30);

        // second high salary emplyee (Sid : 20)
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        // "Ashish" , 10  | "Sid", 20) | "Adam" , 30

        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        });
        int k = 2;
        System.out.println(list.get(k - 1));

        LinkedHashMap<String, Integer> lmap = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            lmap.put(list.get(i).getKey(), list.get(i).getValue());
        }
        System.out.println(lmap);
    }
}

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

  /*  EmployeeEntity
    @ManytoMany
      Set<Employees>  employees mappedBy = insurance.

InsuranceEntity
  @id
  int id,
  Srting name;



    Put | patch

      Employee
      name id salary;  rownumber
      Sid   0  200      1
      Sid    1 20      2
      Sid    1  20     3
       Aash  3  30      3


      Sid    1 20      2
      Aash  3  30      3


      Delete Student from (
      INNNER JOIN
      FROM STUDENT s1 , STUDENT s2,
      where s1.name = s2.name OR s1.id =s2.id
      s1.RowNumber > s2.rownmber );

      //2nd way
*/

}
