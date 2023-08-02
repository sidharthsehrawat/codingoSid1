package folder.hard;

public class LongestValidParentheses {

    public static void main(String[] args) {
       // String str = "{{}{}}}}{{}}";   //   {{}{}}=(6) , {{}}=(4) , {}=(2)
      //  String str = "{{{}}}{";
        String str = "{}{}}}{";
        int res = getLongestParentheses(str);
        System.out.println(res);
        // TC : O(n) + O(n) ~ O(2n) = O(n)
        // SC : O(1).
    }
    // max = Math.max (2-1 = 1  ,  4-0 = 4)

    //
    //
    //
    //
    // }  5
    // }x 4
    // {x 3
    // }x 2
    // {x 1
    // {  0

    private static int getLongestParentheses(String str) {
        int max = 0;
        int leftCount = 0;
        int rightCount = 0;
        char ch = ' ';
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '{') {
                leftCount++;
            } else if (ch == '}') {
                rightCount++;
            }

            if (leftCount == rightCount) {
                max = Math.max(max, 2 * leftCount);
            }

            if (rightCount > leftCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }

        leftCount = 0;
        rightCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            if (ch == '{') {
                leftCount++;
            } else if (ch == '}') {
                rightCount++;
            }
            if (leftCount == rightCount) {
                max = Math.max(max, 2 * rightCount);
            }

            if (leftCount > rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }
        return max;
    }

}
