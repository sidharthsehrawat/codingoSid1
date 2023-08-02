package folder.strings;

public class TransformStringInsertAtfront {
    public static void main(String[] args) {
        String wordA = "EACBD"; //BEACD //ABECD
        String wordB = "EABCD";

        int res = transformString(wordA, wordB);
        System.out.println(res);
    }

    private static int transformString(String wordA, String wordB) {
        // loop from end of both String , if char diff , replace with empty char , and append unmatching char to front side..
        // length should be same..
        int n = wordA.length();
        int i = n - 1;
        int j = n - 1;
        int res = 0;
        while (i >= 0 && j >= 0) {
            while (i >= 0 && wordA.charAt(i) != wordB.charAt(j)) {
                i--;
                res++;
            }
            i--;
            j--;
        }
        return res;
    }
}
