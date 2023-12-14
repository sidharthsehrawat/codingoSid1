package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestEP2 {
    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "10";
        // 0 1 2
        //   1 1 2  = >    0 2 3 2 -> 2320 (reversing..)

        // 0 1 2
        // 0 1
        int end = s2.length();
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        int index = 0;
        int index2 =0;
        for (int i = end-1; i >= 0; i--) {
            int num2 = s2.charAt(i) - '0';
            int end2 = s1.length()-1;
            while (end2 >= 0) {
                if(i ==s2.length()-1 ){
                    int num1 = s1.charAt(end2) - '0';
                    int prod = num1 * num2;
                    if (carry > 0) {
                        prod = prod + carry;
                    }
                    if (prod > 9) {
                        carry = prod / 10;
                        prod = prod % 10;
                    }
                    list.add(prod);
                }else{
                    int num1 = s1.charAt(end2) - '0';
                    int prod = num1 * num2;
                    if (carry > 0) {
                        prod = prod + carry;
                    }
                    prod =  prod + list.get(index);
                    if (prod > 9) {
                        carry = prod / 10;
                        prod = prod % 10;
                    }
                        int numf  = list.get(index);
                    prod = prod+ numf;
                        list.add(index,  prod);

                        index++;
                        list.remove(list.size()-1);
                }
                end2--;
            }
            if(carry>0){
                list.add(carry);
            }
            carry = 0;
            index2++;
            index = index2;
        }

        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();

        for(int n: list){
            sb.append(n);
        }

        System.out.println("multiplying :" + sb.toString());
    }
}
