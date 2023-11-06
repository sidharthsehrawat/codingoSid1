package Test;

import java.util.Arrays;
import java.util.List;

public class MCQ {

    public static void main(String[] args) {

        int Integer = 24;
        char String  = 'I';
        System.out.print(Integer);
        System.out.print(String);

        List<String> list = Arrays.asList("foo", "hel","loo","horse");
        String ans = list.stream().filter(s -> s.endsWith("oo")).findFirst().orElse("horse");
        System.out.println(ans);



    /*  short x = 10;
        x =  x * 5;
       System.out.print(x);    */

     /*   byte x = 127;
        x++;
        x++;
        System.out.print(x);  op = -127 range is -128 to 127  cyclic range */



      /*  int[]  x = {120, 200, 016};
        for(int i = 0; i < x.length; i++){
            System.out.print(x[i] + " ");
        }  //op = 120 200 14 , 016 is octal number
*/


        int a = 100;
        System.out.println(++a);






    }
}
