package folder.strings;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {

        boolean res = repeatedSubstringPattern("aabaab");
        // abc abcabc
        System.out.println(res);

    }

    public static boolean repeatedSubstringPattern(String s) {
        if( s.length()==3){
            if(s.charAt(1) == s.charAt(0) && s.charAt(1) == s.charAt(2)){
                return true;
            }

        }
        // a aaa
        int len = s.length();
        int maxLen = len/2 ;
        for(int i=0; i< maxLen;i++){
            String sub = s.substring(0,i+1);
            int leng = sub.length();

            if(leng == maxLen){
                if(sub.equals(s.substring(i+1,s.length()))){
                    return true;
                }
            }else {
                int op = s.length()/leng;
                String ans = "";
                for(int j =0; j<op; j++){
                    ans= ans + sub;
                }

                if(ans.equals(s)){
                    return true;
                }
            }
        }
        return false;

    }
}

