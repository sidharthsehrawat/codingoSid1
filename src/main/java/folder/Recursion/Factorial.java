package folder.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Factorial {
    public static void main(String[] args) {
        int num = 9;
        int stairs = 4;
        // printNum(num);
        // factorial(num);
       // fibonaaci(num);
        int[] dp = new int[10];
        for (int i = 0; i < num; i++) {
            dp[i] = 0;
        }
        //   int re = fibonaaciMemoization(dp,num);
        //  System.out.println(re);

        // int sum = summation(5);
        // System.out.println(sum);

        /*int[] arr={1,2,3,4};
        int[] res = swapArr(arr,0,arr.length-1);
        System.out.println(res);
       */

        //  printStairsPath(stairs,"");


        List<String> list = getSubSeq("rabbbit");
        int count =0 ;
        for(String s : list){
            if(s.equals("rabbit")){
                System.out.println(s);
                count++;
            }
        }
        System.out.println(count);

        // printSubSeq("abc","");

        //  int res= countStairsPath(0);
        // System.out.println(res);
        // int res = fibRecur(num);
        // System.out.println(res);
        // System.out.println(getStairsPath(stairs));
    }

    private static int fibonaaciMemoization(int[] dp, int num) {
        //boundary condition
        if (num < 0) {
            return 0;
        }

        if (num == 0 || num == 1) {
            // System.out.println(num);
            return num;
        }
        if (dp[num] != 0) {
            return dp[num];
        }
        if (dp[num] == 0) {
            int fib1 = fibonaaciMemoization(dp, num - 1);
            int fib2 = fibonaaciMemoization(dp, num - 2);
            dp[num] = fib1 + fib2;
            System.out.println(dp[num]);
        }
        return dp[num];
    }

    private static int countStairsPath(int stairs) {
        if (stairs == 0) {
            return 1;
        } else if (stairs < 0) {
            return 0;
        }

        int r1 = countStairsPath(stairs - 1);
        int r2 = countStairsPath(stairs - 2);
        int r3 = countStairsPath(stairs - 3);

        return r1 + r2 + r3;
    }

    private static void printSubSeq(String str, String psf) {
        if (str.length() == 0) {
            System.out.println(psf);
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        printSubSeq(ros, psf + "");
        printSubSeq(ros, psf + ch);
    }

    private static List<String> getSubSeq(String str) {
        if (str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        List<String> gss = getSubSeq(ros);

        List<String> finalList = new ArrayList<>();
        for (String s : gss) {
            finalList.add("" + s);
            finalList.add(ch + s);
        }
        return finalList;
    }

    private static void printStairsPath(int stairs, String path) {
        if (stairs < 0)
            return;

        if (stairs == 0) {
            System.out.println(path);
        }


        printStairsPath(stairs - 1, path + 1);
        printStairsPath(stairs - 2, path + 2);
        printStairsPath(stairs - 3, path + 3);


    }


    private static int[] swapArr(int[] arr, int l, int r) {
        if (l > r) {
            return arr;
        }

        swapD(arr, l, r);
        swapArr(arr, l + 1, r - 1);
        return arr;
    }

    private static void swapD(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static int summation(int num) {
        if (num == 1) {
            return 1;
        }
        int res = num + summation(num - 1);
        return res;
    }

    private static List<String> getStairsPath(int stairs) {
        if (stairs == 0) {
            List<String> path = new ArrayList<>();
            path.add("");
            return path;
        } else if (stairs < 0) {
            List<String> path = new ArrayList<>();
            return path;
        }

        List<String> path1 = getStairsPath(stairs - 1);
        List<String> path2 = getStairsPath(stairs - 2);
        List<String> path3 = getStairsPath(stairs - 3);
        List<String> paths = new ArrayList<>();

        for (String path : path1) {
            paths.add(1 + path);
        }

        for (String path : path2) {
            paths.add(2 + path);
        }

        for (String path : path3) {
            paths.add(3 + path);
        }

        return paths;
    }

    private static int fibRecur(int num) {
        // base condition
        if (num == 0 || num == 1) {
            return num;
        }


        int num1 = fibRecur(num - 1);  // 7 6 5 4 3 2 1
        int num2 = fibRecur(num - 2);  //  6 4 2 0
        int res = num1 + num2;
        return res;
    }

    private static void fibonaaci(int num) {
        //   f s
        // 8  ...   0 1 1 2 3 5 8 13 21
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int first = 0, second = 1, next = 0;
        while (count < num) {
            if (count <= 1) {
                System.out.print(count + " ");
                count++;
            } else {
                next = first + second;
                System.out.print(next + " ");
                first = second;
                second = next;
                count++;
            }
        }
    }

    private static int factorial(int num) {
        int fact = 1;
        if (num == 1) {
            return num;
        }
        fact = num * factorial(num - 1);
        return fact;
    }

    private static void printNum(int num) {
        if (num == 1) {
            return;
        }
        System.out.println(num);
        printNum(num - 1);

    }
}
