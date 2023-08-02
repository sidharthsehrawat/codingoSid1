package folder.hard;

import javafx.util.Pair;

import java.util.*;

public class WordSearch {
    public static void main(String[] args) {
        //  Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        //  Output: 5
        //  Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
        // Trie
        // DP
        // count +=2;}

        //    char[] ch = "abc".toCharArray();
        //   ch[0]='s';
        //  String s = String.valueOf(ch);

        String beginWord = "hit";
        String endWord = "cog";
        List<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");

        int ans = getword(beginWord, endWord, dict);
        System.out.println(ans);
    }


    private static int getword(String beginWord, String endWord, List<String> dict) {
        Pair<String, Integer> pair = new Pair<>(beginWord, 1);
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(pair);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair1 = queue.poll();
            String str = pair1.getKey();
            int steps = pair1.getValue();
            if (str.equals(endWord)) {
                return steps;
            }
            char[] ch = str.toCharArray();

            for (int i = 0; i < str.length(); i++) {
                char original = ch[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    if (dict.contains(String.valueOf(ch))) {
                        queue.add(new Pair<>(String.valueOf(ch), steps + 1));
                        // queue.add(d);
                        dict.remove(str);
                    }
                }
                ch[i] = original;
            }
        }
        return 0;
    }


}
