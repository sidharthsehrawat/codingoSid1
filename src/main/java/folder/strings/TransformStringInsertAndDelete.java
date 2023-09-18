package folder.strings;

public class TransformStringInsertAndDelete {
    public static void main(String[] args) {
        String wordA = "heap";
        String wordB = "pea";
// 1. Get all common subsequence of both string and match one by one for some common subsequence.
// 2. By DP.
        int res = getTransform(wordA, wordB);
        int ans = wordA.length() + wordB.length() - 2 * res;
        System.out.println(ans);
    }

    private static int getTransform(String wordA, String wordB) {
        int[][] dp = new int[wordA.length() + 1][wordB.length() + 1];

        for (int i = wordA.length() - 1; i >= 0; i--) {
            for (int j = wordB.length() - 1; j >= 0; j--) {
                if (wordA.charAt(i) == wordB.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
