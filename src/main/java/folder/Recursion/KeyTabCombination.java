package folder.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyTabCombination {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(",","abc","de", "gh","ijk");
        int num = 21;
        String num1 = Integer.toString(num);
        System.out.println(getCombination(stringList , num1));


    }

    private static List<String> getCombination(List<String> stringList, String num) {
          if(num.length() == 0){
              List<String> list = new ArrayList<>();
              list.add("");
              return list;
          }
          char ch = num.charAt(0);
           String ros = num.substring(1);

           List<String> lists =  getCombination(stringList,ros);
           List<String> finalList = new ArrayList<>();
           String key = stringList.get(ch-'0');
           for(int i=0; i < key.length();i++){
               char ch1 = key.charAt(i);
               for(String st: lists){
                   finalList.add(st+ ch1);
               }
           }

           return  finalList;
    }
}
