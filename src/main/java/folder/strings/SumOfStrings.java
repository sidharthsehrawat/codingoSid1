package folder.strings;

public class SumOfStrings {
    public static void main(String[] args) {
        String num1 = "18";
        String num2 = "99"; // 533
  int n = Integer.parseInt(num1);
  String n1 = String.valueOf(n);

        String res = getRes(num1, num2);
        System.out.println(res);
    }

    private static String getRes(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        String res = "";

        while (i >= 0 || j >= 0) {
            int n1 = 0, n2 = 0, sum = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
                j--;
            }
            sum = n1 + n2;

            if (sum > 10) {
                if (carry > 0) {
                    sum += carry;
                } else {
                    carry++;
                }

                sum = sum - 10;
                res = res + sum;
            } else {
                sum += carry;
                if (sum > 10) {
                    carry = 1;
                    sum = sum - 10;
                }

                res = res + sum;
            }
        }
        if (carry > 0) {
            res = res + carry;
        }

        // reverse the string;
        String ans = "";
        for (int k = res.length() - 1; k >= 0; k--) {
            ans = ans + res.charAt(k);
        }
        return ans;
    }


}

