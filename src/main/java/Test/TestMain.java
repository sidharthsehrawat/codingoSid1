package Test;

public class TestMain {
    public static void main(String[] args) {

        // stock market
        // one single buy and sell ... max profit = ?
        // buy : 0 2  2 3     : sell : 0 4 6 6
        // total : 2  + 4  + 3 =  9
        //             i     // TC : O(n) : SC :O(1).

        int[] share = {2, 4, 2, 5, 6, 3, 4, 6, 3, 9};
        int[] shard = {4, 2, 3, 5, 6, 3, 4, 6, 3, 9};
        int sell = -1;
        int profit = 0;
        int buy = share[0];  // 2
        for (int i = 1; i < share.length; i++) {
            if (share[i - 1] > share[i]) {
                if (share[i - 1] > buy) {
                    profit += share[i - 1] - buy;
                }
                buy = share[i];
            } else {
                if (i == share.length - 1) {
                    if (share[i] > buy) {
                        profit += share[i] - buy;
                    }
                }
            }
        }
        System.out.println("max profit : " + profit);
    }
}
