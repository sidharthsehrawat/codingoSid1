package folder.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {

      /*  int[] arr1 = {1,4,7};
        int[] arr2 = {2,3,5};
        mergeTwoArray(arr1,arr2);*/
         String str= "123";
        //permutation(str, 0, str.length() - 1);
         permutationBySubstring(str,"");
        int n = 3;
        List<String> list = getAllParentheses(n);
       // System.out.println(list);
    }

    private static List<String> getAllParentheses(int n) {
        List<String> getList = getAll(n, "(", 1, 0);
        return getList;
    }


    static List<String> list = new ArrayList<>();

    private static List<String> getAll(int n, String str, int open, int closed) {


        if (str.length() == 2 * n) {
            System.out.println(str);
            list.add(str);
        }
        if (open < n) {
            getAll(n, str + "(", open + 1, closed);
        }
        if (closed < open) {
            getAll(n, str + ")", open, closed + 1);
        }
        return list;
    }

    private static void permutationBySubstring(String str, String psf) {

        if (str.length() == 0) {
            System.out.println(psf);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String lpart = str.substring(0, i);
            String rpart = str.substring(i + 1);
            String ros = lpart + rpart;
            permutationBySubstring(ros, psf + ch);
        }
    }

    private static void permutation(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        }
        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            permutation(str, l + 1, r);
            str = swap(str, l, i);

        }
    }

    public static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return String.valueOf(ch);
    }


    private static void mergeTwoArray(int[] arr1, int[] arr2) {
        int[] finalList = new int[arr1.length + arr2.length];


        int p1 = 0;
        int p2 = 0;
        int k = 0;
        // 1,2 3 4 5
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                finalList[k] = arr1[p1];
                k++;
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                finalList[k] = arr2[p2];
                p2++;
                k++;
            }
        }

        for (int i = p1; i < arr1.length; i++) {
            finalList[k] = arr1[p1];
            k++;
        }
        for (int i = p2; i < arr2.length; i++) {
            finalList[k] = arr1[p1];
            k++;
        }
    }

}








