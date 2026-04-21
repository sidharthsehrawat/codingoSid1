package your;

public class HouseRobberIWithoutDP {
    public static void main(String[] args) {
        int[] houses = {1,2,1,1};
        int amount = houseRobber(houses);
        System.out.println("Amount " + amount);
    }

    private static int houseRobber(int[] houses) {
        if(houses.length == 0 ) return 0;
        if(houses.length == 1) return houses[0];
        int prev1 = Math.max(houses[0], houses[1]);
        int prev2 = houses[0];

        for(int i = 2 ;i < houses.length ; i++) {
            int amount = Math.max(houses[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = amount;
        }
        return prev1;
    }
}
