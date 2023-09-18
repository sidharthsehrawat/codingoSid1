package folder.strings;

import java.util.HashMap;
import java.util.Map;

public class TestMock {
    public static String customSortString(String order, String s) {

        // c b a
        // a b c d

        // c b a f g
        // a b c d
        //  c b a d . ans

        // a b
        // c c b d a e a
        // a a b ans


        Map<Character , Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }
        }
        int k=0;
        char[] ch = new char[s.length()];
        for(int j=0;j<order.length();j++){
            if(map.containsKey(order.charAt(j))){
                for(int i= 0;i<map.get(order.charAt(j));i++){
                    ch[k]= order.charAt(j);
                    k++;

                }
                map.remove(order.charAt(j));
            }
        }
        int siz = 0;
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                siz = entry.getValue();
                for(int y= 0 ; y<siz; y++){
                    ch[k] = entry.getKey();
                    k++;
                }


            }

        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String res = customSortString("exv", "xwvee");
        System.out.println(res);
    }
}
