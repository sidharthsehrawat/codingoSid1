package revision.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumTeachings {
    public static void main(String[] args) {
        int n =3;
        int[][] languages = {
                {2},
                {1,3},
                {1,2},
                {3}};
        int[][] friendships = {
                {1,4},
                {1,2},
                {3,4},
                {2,3}};

        int res = minimumTeachings(n, languages, friendships);
        System.out.println(res);

    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int k = 1;
        for (int[] arr : languages) {
            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
            }
            map.put(k++, set);  // users are 1-indexed
        }

        // Step 1: collect all users in friendships who can't communicate
        Set<Integer> needTeach = new HashSet<>();
        for (int[] group : friendships) {
            int user1 = group[0];
            int user2 = group[1];

            Set<Integer> lang1 = map.get(user1);
            Set<Integer> lang2 = map.get(user2);

            boolean found = false;
            for (int a : lang1) {
                if (lang2.contains(a)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                needTeach.add(user1);
                needTeach.add(user2);
            }
        }

        // Step 2: check each language and find the min number of teachings
        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : needTeach) {
                if (!map.get(user).contains(lang)) {
                    count++;
                }
            }
            ans = Math.min(ans, count);
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
