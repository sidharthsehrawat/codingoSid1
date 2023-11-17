package Test;

public class Test5 {
   /*

   Write a function, add,  which adds two large numbers together and returns their sum:
    // Returns sum of two numbers
    String add(String a, String b)
    Inputs to the add function are two numbers, represented as strings
    Output of the add function is a single string representing the sum of the inputs
   // Basic Test
    assertAdd("1", "5")
    sb = "";
    "8457 3637457575" + "7437 6239848234"  ans = "03809";
    */

    public static void main(String[] args) {
       /* System.out.println(add("2222","4444"));
        System.out.println(add("76","72"));
        System.out.println(add("999","111"));
        System.out.println(add("5555","4444"));
        System.out.println(add("55","2222"));
        System.out.println(add("1","99"));*/
        System.out.println(add("999", "1"));
    }

    static String add(String str1, String str2) {
        StringBuilder ans = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0;
        int currentSum = 0;
        while (i >= 0 && j >= 0) {
            int num1 = str1.charAt(i) - '0';
            int num2 = str2.charAt(j) - '0';
            if (num1 + num2 >= 10) {
                currentSum = (num1 + num2) % 10;
                if (carry > 0) {
                    currentSum = currentSum + carry;
                }
                if (currentSum == 10) {
                    carry = 1;
                } else {
                    carry = (num1 + num2) / 10;
                }
            } else {
                if (carry > 0) {
                    currentSum = num1 + num2 + carry;
                    carry = 0;
                } else {
                    currentSum = num1 + num2;
                }

            }//
            ans.append(currentSum); // reverse at last
            i--;
            j--;
        }


        while (i >= 0) {
            int num1 = str1.charAt(i) - '0';
            if (carry > 0) {
                num1 = num1 + carry;  // 9   10
            }
            if (num1 > 9 && i ==0) {
                StringBuilder sb = new StringBuilder();
                sb.append(num1);
                sb.reverse();
                ans.append(sb);
            } else {
                ans.append(num1);
            }
            carry = 0;
            i--;
        }


        while (j >= 0) {
            int num1 = str2.charAt(j) - '0';
            if (carry > 0) {
                num1 = num1 + carry;  // 9   10
            }

            if (num1 > 9 && j ==0) {
                StringBuilder sb = new StringBuilder();
                sb.append(num1);
                sb.reverse();
                ans.append(sb);
            } else {
                 num1 = num1%10;
                int num = num1/10;
                ans.append(num);
            }
            carry = 0;
            j--;
        }

        if (carry > 0) {
            ans.append(carry);
        }
        ans.reverse();
        return String.valueOf(ans);
    }
}
