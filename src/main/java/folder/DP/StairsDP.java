package folder.DP;

public class StairsDP {
    public static void main(String[] args) {
        /*int stairs = 4;
        int count = getTotalStairsPathDP(stairs);
        System.out.println(count);*/
        int stairs =7;
       // int minStep = getMinStepsDP123(stairs);
       // System.out.println(minStep);
        int[] arr= {2,5,3,1,4,5,3,2,1};
         // dp = [0,0,0,0,0,0,0,0,0,0]
        //int res = getMinStepsDPRandomStep(arr);
        int coins[] ={2,3,5};
        int countCoins = getCoinsCount(coins,8);
        System.out.println(countCoins);
    }

    private static int getCoinsCount(int[] coins, int price) {
        int[] dp = new int[price+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++) {
            for(int j=coins[i];j<dp.length;j++) {
              dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[price];
    }

    private static int getMinStepsDPRandomStep(int[] arr) {
        Integer[] dp = new Integer[arr.length+1];
        dp[arr.length]=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>0){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=arr[i] && i+j<dp.length;j++){
                if(dp[i+j]!=null){
                    min = Math.min(min,dp[i+j]);
                }

            }
            dp[i]=min+1;
            }
        }
        return dp[0];
    }

    private static int getMinStepsDP123(int stairs) {

        int[] arr = new int[stairs+1];
        arr[0]=1;
        for(int i=1;i<arr.length;i++){
            if(i==1){
                arr[i]= 1;
            } else if (i==2) {
                arr[i]= 1;
            }else if(i==3){
                arr[i]= 1;
            }else {
                arr[i] = arr[i-3]+1;
            }
        }

        return arr[stairs];
    }

    private static int getTotalStairsPathDP(int stairs) {
        int[] arr = new int[stairs+1];
        arr[0]=1;
        for (int i=1;i<arr.length;i++){
            if(i==1){
                arr[i]=arr[i-1];
            }else if(i==2){
                arr[i]=arr[i-1]+arr[i-2];
            }else {
                arr[i]=arr[i-1]+arr[i-2]+ arr[i-3];
            }

        }
        return arr[stairs];
    }
}
