package folder.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2 {
    static class Pair {
        int hor;
        int ver;

        public Pair(int hor, int ver) {
            this.hor = hor;
            this.ver = ver;
        }

        public int getHor() {
            return hor;
        }

        public int getVer() {
            return ver;
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'd'},
                {'b', 'c'}

        };
        String[] words = {"ab", "adc", "dcb", "cc"};
        List<String> finalList = new ArrayList();
        boolean result = false;
        // for all words
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        // adding values in map for better search.
        Map<Character, List<Pair>> map = new HashMap<>();
        for (String word : words) {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[0].length; c++) {
                    if (matrix[r][c] == word.charAt(0)) {
                        if (!map.containsKey(word.charAt(0))) {
                            List<Pair> list = new ArrayList<>();
                            Pair pair = new Pair(r, c);
                            list.add(pair);
                            map.put(word.charAt(0), list);
                        } else {
                            List<Pair> pairList = map.get(word.charAt(0));
                            Pair pair = new Pair(r, c);
                            pairList.add(pair);
                            map.put(word.charAt(0), pairList);
                        }
                    }
                }
            }
        }

        for (String word : words) {
            char startingWord = word.charAt(0);
            List<Pair> pairList = map.get(startingWord);
            if (pairList != null) {
                for (Pair pair : pairList) {
                    if (pair != null) {
                        result = findword(matrix, pair.getHor(), pair.getVer(), word, visited, 0);
                        if (result) {
                            if(!finalList.contains(word)) finalList.add(word);
                        }
                    }

                }

            }
        }
        System.out.println("finalList : " + finalList);
    }

    public static boolean findword(char[][] matrix, int r, int c, String word, boolean[][] visited, int index) {
        // base condition
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || visited[r][c] || matrix[r][c] != word.charAt(index)) {
            return false;
        }
        visited[r][c] = true;
        if (matrix[r][c] == word.charAt(index)) {
            index++;
        }
        if (index == word.length()) {
            return true;
        }
        boolean top = findword(matrix, r - 1, c, word, visited, index);
        boolean left = findword(matrix, r, c - 1, word, visited, index);
        boolean bottom = findword(matrix, r + 1, c, word, visited, index);
        boolean right = findword(matrix, r, c + 1, word, visited, index);
        visited[r][c] = false;
        return top || left || bottom || right;
    }
}
