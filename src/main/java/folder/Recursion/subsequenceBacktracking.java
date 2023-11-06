package folder.Recursion;

import java.util.ArrayList;
import java.util.List;

public class subsequenceBacktracking {
    public static void main(String[] args) {
        String num = "312";
        List<Character> list = new ArrayList<>();
        getSubSeq(num, list, 0, 0);
    }

    private static void getSubSeq(String num, List<Character> list, int index, int sum) {
        if (index >= num.length()) {
            //System.out.println(list);

            if(sum ==3){
                System.out.println("list element equals to target sum : " + list);
            }
            return;
        }
        list.add(num.charAt(index));
        getSubSeq(num, list, index + 1, sum + num.charAt(index) - '0');
        list.remove(list.size() - 1);
       // sum = sum - num.charAt(index) - '0';
        getSubSeq(num, list, index + 1, sum );
    }
}

