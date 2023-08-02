package folder.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "123";
        int target  = 6;

        List<String> list = getOperators(num, "");

    }

    private static List<String> getOperators(String num, String psf) {
        if(num.length()==0){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = num.charAt(0);
        String str = num.substring(1);
        List<String> gsM =getOperators(str, psf + ch + "*");
        List<String> gsP =getOperators(str, psf + ch + "+");
        List<String> gsS =getOperators(str, psf + ch + "-");
        List<String> finalList = new ArrayList<>();

        for(String s : gsM){
            finalList.add(s + "*");
        }

        for(String s : gsP){
            finalList.add(s + "*");
        }

        for(String s : gsS){
            finalList.add("" + "*"+ ch);
        }

        return null;
    }


}
