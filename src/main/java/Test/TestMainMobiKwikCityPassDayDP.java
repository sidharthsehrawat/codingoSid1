package Test;

import java.util.*;

public class TestMainMobiKwikCityPassDayDP {
    public static void main(String[] args) {

        // test case 1  passMap (1,2) (7,7) (30,30) , int input[] = {1, 3, 4, 5, 6, 15, 17, 23, 24, 25, 31};  output = 17
        // test case 2  passMap (1,2) (7,7) (30,30) , int input[] = {1, 3, 4, 5, 6, 15, 17, 23, 24, 25, 31};  output = 23
        // test case 3  passMap (1,2) (7,7) (30,30)  , int input[] = {1, 3, 4, 5, 6, 15, 17, 23, 24, 25, 31, 100 , 150 };  output = 31
        // test case 4  passMap (2,2) (7,10) (30,20)  , int input[] = {1, 3, 4, 5, 6, 15, 17, 31, 100 , 150 };  output = 20
        // test case 5  passMap (2,2) (7,10) (30,20)  , int input[] = {1, 3, 4, 5, 6, 15, 17, 31, 100 , 150, 900, 996 };  output = 22

   //  ========= test case 1  ================ output = 7

      /*  int input[] = {1, 3, 4, 5, 6};
        TreeMap<Integer, Integer> passMap = new TreeMap<>();
        passMap.put(1, 2);
        passMap.put(7, 7);
        passMap.put(30, 20);

       // added one validity ,map to validate the pass according to days to search pass validity in O(1) constant time .
        TreeMap<Integer, Integer> validityMap = new TreeMap<>();
        validityMap.put(1, -1);
        validityMap.put(7, -1);
        validityMap.put(30, -1);*/

   // ================================================



   //  ========= test case 2  ================ output = 17

      /* int input[] = {1, 3, 4, 5, 6, 15, 17, 23, 24, 25, 31};
        TreeMap<Integer, Integer> passMap = new TreeMap<>();
        passMap.put(1, 2);
        passMap.put(7, 7);
        passMap.put(30, 15);

        // added one validity ,map to validate the pass according to days to search pass validity in O(1) constant time .
        TreeMap<Integer, Integer> validityMap = new TreeMap<>();
        validityMap.put(1, -1);
        validityMap.put(7, -1);
        validityMap.put(30, -1);*/

   // ================================================



    //  ========= test case 3  ================ output = 14

   /*     int input[] = {1, 3, 4, 5, 6, 15, 17 };
        TreeMap<Integer, Integer> passMap = new TreeMap<>();
        passMap.put(1, 2);
        passMap.put(7, 10);
        passMap.put(30, 15);

        // added one validity ,map to validate the pass according to days to search pass validity in O(1) constant time .
        TreeMap<Integer, Integer> validityMap = new TreeMap<>();
        validityMap.put(1, -1);
        validityMap.put(7, -1);
        validityMap.put(30, -1);*/

   // ================================================


    //  ========= test case 4 ================ output = 4

        int input[] = {1, 3 };
        TreeMap<Integer, Integer> passMap = new TreeMap<>();
        passMap.put(1, 2);
        passMap.put(7, 10);
        passMap.put(30, 15);

        // added one validity ,map to validate the pass according to days to search pass validity in O(1) constant time .
        TreeMap<Integer, Integer> validityMap = new TreeMap<>();
        validityMap.put(1, -1);
        validityMap.put(7, -1);
        validityMap.put(30, -1);

        // ================================================





        List<Integer> passList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : passMap.entrySet()) {
            passList.add(entry.getKey());
        }


        List<Integer> amount = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            int day = input[i];
            // add validity..
            for (int j = 0; j < passList.size(); j++) {
                int pass = passList.get(j);
                if (i == 0 && validityMap.get(pass) < day) {
                    validityMap.put(pass, pass + day - 1);
                }
            }
            int dollar = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : validityMap.entrySet()) {
                int passValid = entry.getValue();
                int passDay = entry.getKey();
                if (passValid >= day && passDay>=day) {
                    if (dollar > passMap.get(passDay)) {
                        dollar = passMap.get(passDay);
                    }
                } else {
                    int sum = passMap.get(passDay) + amount.get(i - 1);
                    if(dollar > sum){
                        dollar = sum;
                    }
                    //dollar = passMap.get(passDay) + amount.get(i - 1);
                    validityMap.put(passDay, passDay + day - 1);
                }
            }
            amount.add(dollar);
        }
        System.out.println("Min Amount in dollar $ " + amount.get(amount.size() - 1));
    }
}
// SC - O(N).
// TC - O(N).
// logic DP() Implemented by own DP logic
// can be done using recurssive approach as well, but it will take O(N^2) + stack space O(N) complexity..
