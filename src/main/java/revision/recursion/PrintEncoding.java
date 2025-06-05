package revision.recursion;

public class PrintEncoding {
    public static void main(String[] args) {
        String num = "123";
        String[] arr = {"a","b","c","d","e","f","g","h","i","j","k",
                "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        printEncoding(num, arr, "");
    }

    private static void printEncoding(String num, String[] arr, String psf) {

        if(num.isEmpty()) {
            System.out.println(psf);
            return;
        }
        int number = num.charAt(0)-'0';
        if(number == 0) return;
        String ros = num.substring(1);
        printEncoding(ros, arr, psf + arr[number-1]);

        if(num.length()>=2){
            int number1 = Integer.parseInt(num.substring(0,2));
            if(number1>=10 && number1<=26){
                String ros1 = num.substring(2);
                printEncoding(ros1, arr, psf + arr[number1-1]);
            }
        }
    }
}
