package revision.array;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        int n = 231;
        int ans = nextGreaterElement(n);
        System.out.println("ans " + ans);

    }

    public static int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        char[] ch = num.toCharArray();

        int j = ch.length-2;
        while(j>=0 && ch[j] >= ch[j+1]){
            j--;
        }
        if(j < 0) return -1;
        //     j   i
        // 7 6 2 6 5 1
        // 7 6 5 6 2 1

        int i = ch.length-1;
        while(i>=0 && ch[i] <= ch[j]){
            i--;
        }

        // swap
        char temp = ch[j];
        ch[j] = ch[i];
        ch[i] = temp;

        // now reverse the array after
        int end = ch.length-1;
        int start = j+1;
        while(start<end){
            char temp1 = ch[start];
            ch[start] = ch[end];
            ch[end] = temp1;
            start++;
            end--;
        }

        String ans = String.valueOf(ch);
        long result = Long.parseLong(ans);
        return result<=Integer.MAX_VALUE ? (int) result : -1;

    }
}
