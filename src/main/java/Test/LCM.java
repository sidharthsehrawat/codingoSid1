package Test;

public class LCM {
    public static void main(String[] args) {
        int num = 16;
         // 2 2 2 2
        int lim = (int) Math.sqrt(num);
        int rem = 0;

        int i = 2;
        while (i <= lim && num >= 0) {
            if ((num % i) == 0) {
                rem = num / i;
                num = rem;
                System.out.print(i + " ");
            } else {
                i++;
            }
        }
    }
}




