package folder.strings;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class DecodedString {
    public static void main(String[] args) {
        String s = "leet2code3";
        // leetleetcode leetleetcodeleet leetcode
        int k =20;
        String res= getres (s,k);
        System.out.println(res);

    }

    private static String getres(String s, int k) {
        long len =0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                len *= s.charAt(i)- '0';
            }else {
                len = len +1;
            }
        }

        int l =k;
        for(int j = s.length()-1 ;j>=0;j--){
            if(Character.isDigit(s.charAt(j))){
                len /= s.charAt(j)-'0';
                k %= len;

            }else {
                if(k==0 || k ==len){
                    return "" + s.charAt(j);
                }
                len--;
            }
        }
    return  "";
    }
}
