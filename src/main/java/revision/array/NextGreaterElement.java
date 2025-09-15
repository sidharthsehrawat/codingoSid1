package revision.array;

import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,1);
        List<Integer> l2 = Arrays.asList(1);
        Set<Integer> set1 = new HashSet<>(l1);
        Set<Integer> set2 = new HashSet<>(l2);
        for(int a : set1){
            System.out.println(a);

        }

        System.out.println("set "+ set1);



                 //  0   1   2   3    4   5   6
        int[] arr = {20, 10, 35, 10 , 20, 40, 25};
        //           35  35  40   20  40  0   0


        int[] input = {20, 10, 35, 10 , 20, 40, 25};
        // output           25  20  40  20   25  0   0
        int[] res = getNextFunc(arr);
        System.out.println(res);
    }

    private static int[] getNextFunc(int[] arr) {
        return null;
    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer , Set<Integer>> map = new HashMap<>();
        int k = 0;
        int ans = 0;
        for(int[] arr : languages){
            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
            }
        }

        for(int[] group : friendships){
            int user1 = group[0];
            int user2 = group[1];

            Set<Integer> lang1 = map.get(user1);
            Set<Integer> lang2 = map.get(user2);

            for(int a : lang1){
                if(!lang2.contains(a)){
                    lang2.add(a);
                    map.put(user2, lang2);
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
