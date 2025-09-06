package folder.strings;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class DecodedString {
    public static void main(String[] args) {
        String s = "leet2code3";
        String res = getres(s);
        System.out.println(res);

    }

    private static String getres(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int count = s.charAt(i) - '0';
                while (count > 0) {
                    sb1.append(sb);
                    count--;
                }
                sb.setLength(0);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb1.toString();
    }
}
