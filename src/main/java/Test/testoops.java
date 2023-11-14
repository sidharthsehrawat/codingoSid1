package Test;

public class testoops {
    public static void main(String[] args) {

        double a, b, c, aa;
        a = 3.0/0; // infinity
        aa = 3.0/0.0;
        b = 0/4.0; // 0
        c = 0/0.0; // nan

        int a1, b1,c1;
       // a1 = 3/0; // aritmaticexception
        b1 = 0/4; // nan
      //  c1 = 0/0; // 0

        float a2, b2,c2;
        a2 = 3f/0f;
        b2 = 0f/4f;
        c2 = 0f/0f;




        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


        int sum = consecutive(15);
        System.out.println(sum);

    }

    public static int consecutive(long num) {
        // Write your code here
        int numValue = (int)num;
        int possibleRange = (numValue/2) +1;
        int sum = 0;
        int count =0;
        for(int i=1 ; i<=possibleRange; i++ ){
            sum = sum+i;
            for(int j=i+1;j<=possibleRange;j++){
                sum = sum + j;
                if(sum == numValue){
                    count++;
                    sum = 0;
                    break;
                }
            }
            sum =0 ;
        }
        return count;
    }
}
