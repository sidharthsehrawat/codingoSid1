package revision.recursion;
import java.util.Arrays;

public class Permuation {
    public static void main(String[] args) {
        String str = "bab";
        char ch[] = str.toCharArray();
        Arrays.sort(ch);
        str = String.valueOf(ch);
        int l = 0;
        int r = str.length();
        permutation(str, l, r);
    }
    private static void permutation(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        }

        for (int i = l; i < r; i++) {
            if (i < r - 1 && str.charAt(i) == str.charAt(i + 1)) {
                continue;
            }
            str = swap(str, l, i);
            permutation(str, l + 1, r);
            str = swap(str, l, i);
        }
    }

    private static String swap(String str, int l, int i) {
        char[] ch = str.toCharArray();
        char temp = ch[l];
        ch[l] = ch[i];
        ch[i] = temp;
        return String.valueOf(ch);
    }
}
