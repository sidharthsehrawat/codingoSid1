package folder.strings;

public class SumOfStrings {
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "999"; // 533
        String res = getRes(num1, num2);
        System.out.println(res);
    }

    private static String getRes(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int diff;
        if (len1 > len2) {
            diff = len1 - len2;
            for (int i = 1; i <= diff; i++) {
                num2 = "0" + num2;
            }
        } else {
            diff = len2 - len1;
            for (int i = 1; i <= diff; i++) {
                num1 = "0" + num1;
            }
        }
        // "001" + "999" = 1000
        int carry = 0;

        return "";

    }


}

