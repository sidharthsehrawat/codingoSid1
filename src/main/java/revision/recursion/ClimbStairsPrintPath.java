package revision.recursion;

public class ClimbStairsPrintPath {
    public static void main(String[] args) {
        int num = 3;
        printStairsPath(num, "", 0);
    }

    private static void printStairsPath(int num, String psf, int start) {
        if(start >num){
            return;
        }
        if(start == num){
            System.out.println(" " + psf);
        }

        printStairsPath(num , psf+"1", start+1);
        printStairsPath(num , psf+"2", start+2);
    }
}
