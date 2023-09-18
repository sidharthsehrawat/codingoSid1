package folder.array;

import java.util.Stack;

public class LongestSubarrayOFDistinctElements {
    public static void main(String[] args) {
        int[] arr = {1,5,3,5,2,3,4,1};
        // OP:      [5,2,3,4,1] length = 5
    }
}

// int[] arr = {1,5,3,5,2,3,4,1};
/*
max = 4
start =0; // 3

5 , 3
2 , 4
3 , 5
4 , 6
1 , 7

only one LinkedHashMap required. O(N) space , Time - O(N)

*/
