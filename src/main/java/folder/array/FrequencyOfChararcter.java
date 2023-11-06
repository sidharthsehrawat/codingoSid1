package folder.array;

public class FrequencyOfChararcter {
    public static void main(String[] args) {
       // String s = "AAAABBBCCDDDD";
        //A4B3C2D4
        String s = "ABCAAABBBCCDDDD";
         int[] res = new int[26];
         for(int i=0;i<s.length();i++){
             if(res[s.charAt(i) - 'A']==0){
                 res[s.charAt(i) - 'A']=1;
             }else {
                 res[s.charAt(i) - 'A']+=1;
             }
         }

        for(int i=0;i<s.length();i++){
           char ch =s.charAt(i);
           if(res[ch-'A']>0){
               System.out.print("" + ch + res[ch-'A']);
               res[ch-'A']=0;
           }
        }
        //op = ASB3C2D4
    }

}
