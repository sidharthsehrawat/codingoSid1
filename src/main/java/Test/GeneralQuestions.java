package Test;

import java.util.Arrays;

public class GeneralQuestions {
    public static void main(String[] args) {
       String str1 = "BABAB";
       String str2 = "ABAB";


        char ch  = '\u0099';
      //  String str1 = "a";
        byte[] a = str1.getBytes();
        char[] chars = new char[] {'-'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));




    }
}

