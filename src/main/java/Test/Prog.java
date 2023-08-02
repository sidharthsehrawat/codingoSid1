package Test;

public class Prog {
    public static void main(String[] args) {

       // int[] money ={21,45,67,34,22,55,99,77};

        int[] money ={51,0};
       // int min = Integer.MIN_VALUE;
         int[] dp = new int[money.length];

         dp[0]=Math.max(0,money[0]);
         dp[1]=Math.max(0,money[1]);

         for(int i=2;i< dp.length;i++){
            int mon = money[i];
            if(mon+money[i-2]<0){
                dp[i] = dp[i-2];
            }else{
                dp[i] = Math.max(dp[i-1],mon+money[i-2]);}
         }
              if(dp[dp.length - 1] < 0){
                  System.out.println(0);
              }else {
                  System.out.println(Math.max(dp[dp.length - 1],dp[dp.length - 2]));
              }
    }


}


//[100, 1 ,3 ,51] =>

//[21,45,67,34,22,55, 99,77]
 // 45 + 34 + 55 + 77
 //   53 + 90

//      0  1  2  3  4   5   6   7
// DP : 21 45 88 88 110 143 209 220

    //143 +77
       // return max amount
   // You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from
    //    robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were
   //     broken into on the same night.
    //   Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.