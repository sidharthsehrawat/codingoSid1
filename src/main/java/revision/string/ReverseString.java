package revision.string;

public class ReverseString {
    public static void main(String[] args) {
        String s = "ABC";
        String ans  = reverse(s);
        System.out.println("ans " + ans);
    }

    public static String reverse(String str){
        int i = 0;
        int j = str.length()-1;

        char[] ch = str.toCharArray();
        int mid = j/2;
        while (i<=mid){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(ch);
    }
}
