package Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestEY {
    public static void main(String[] args) {
        String str = "My Name is Sidharth and I am a football fan";
        String[] stringList = {"football", "Name"};

        Predicate<String> predicate = e-> !e.startsWith(stringList[0]) && !e.startsWith(stringList[1]);

        List<String> sl =  Arrays.stream(str.split(" ")).filter(predicate).collect(Collectors.toList());
        StringBuilder ob = new StringBuilder();
        for(String s : sl){
            ob.append(s);
            ob.append(" ");
        }
        String ans = ob.toString();
        System.out.println(ans);

    }
}
