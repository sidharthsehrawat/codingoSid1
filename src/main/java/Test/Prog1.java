package Test;

import java.util.*;

public class Prog1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("manish-2", "mayank-6", "ajay-7", "trisha-1", "shubh-4", "mark-3", "vinay-5", "sam-1");

        Collections.sort(list, (o1, o2) -> {
            String[] arr = o1.split("-");
            String[] arr1 = o2.split("-");
            if (Integer.parseInt(arr[1]) > Integer.parseInt(arr1[1])) {
                return 1;
            } else if(Integer.parseInt(arr[1]) < Integer.parseInt(arr1[1])) {
                return -1;
            }else {
               return arr[0].compareTo(arr1[0]);

            }
        });

        System.out.println(list);


     /* Map<String,Integer> map = new HashMap<>();
      for(int i=0;i<list.size();i++){
          String[] arr = list.get(i).split("-");
          map.put(arr[0],Integer.valueOf(arr[1]));
      }


        List<Map.Entry<String , Integer>> list = Collections.sort();
    }
*/

    }
}


//["manish-2", "mayank-6", "ajay-7", "trisha-1", "shubh-4", "mark-3", "vinay-5", "sam-1"]

//manish- 2

//List<Entry<String , Integer>>