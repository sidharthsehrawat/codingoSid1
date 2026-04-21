package your;

public class FrequencyOFCHAR {
    public static void main(String[] args) {
        String s = "ABCAAABBBCCDDDD";
        int[] res = new int[26];
        for (char ch : s.toCharArray()) {
            res[ch - 'A'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (res[ch - 'A'] > 0) {
                System.out.println(ch + "-> " + res[ch - 'A']);
            }
            res[ch - 'A'] = 0;
        }
    }
}