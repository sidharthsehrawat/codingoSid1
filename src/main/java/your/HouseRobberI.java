package your;

public class HouseRobberI {
    public static void main(String[] args) {
        int[] houses = {1, 2, 1, 1};
        int result = funcHouses(houses);
        System.out.println("max amount robber can get " + result);
    }

    private static int funcHouses(int[] houses) {
        int[] dp = new int[houses.length];
        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[1];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length-1];
    }
}
