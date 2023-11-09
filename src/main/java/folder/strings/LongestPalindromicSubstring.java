package folder.strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aaa"; // c
        int res = countSubstrings(s);
        System.out.println(res);

        String ans = longestPalindrome(s);
        System.out.println("ans : " + ans);
    }

    public static String longestPalindrome(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        String ans = "";
        int count =0;
        for (int gap = 0; gap < size; gap++) {
            int i = 0;
            for (int j = gap; j < dp[0].length; j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                    ans = s.substring(i, j + 1);
                    System.out.println(ans);
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        ans = s.substring(i, j + 1);
                        System.out.println(ans);
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == (s.charAt(j))) {
                        if (dp[i + 1][j - 1] == true) {
                            dp[i][j] = true;
                            ans = s.substring(i, j + 1);
                            System.out.println(ans);
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
                i++;

            }
        }
        return ans;

    }



    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int gap = 0 ; gap<dp.length;gap++){
            int i = 0;
            for(int j =gap ;j<dp[0].length;j++){
                if(gap==0){
                    dp[i][j] = true;
                    count++;
                }else if(gap ==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }else {
                        dp[i][j] = false;
                    }
                }else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        count++;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
            i++;
        }
        return count;
    }
}


 /*if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;

            } else {
                return s.substring(0, 1);
            }
        }*/