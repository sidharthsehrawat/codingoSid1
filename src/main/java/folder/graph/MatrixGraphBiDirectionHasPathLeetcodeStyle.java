package folder.graph;

import java.util.HashMap;
import java.util.Map;

public class MatrixGraphBiDirectionHasPathLeetcodeStyle {
    public static void main(String[] args) {
        int source = 5;
        int destination = 9;
        int n = 10;
        int[][] edges = {
                {4, 3},
                {1, 4},
                {4, 8},
                {1, 7},
                {6, 4},
                {4, 2},
                {7, 4},
                {4, 0},
                {0, 9},
                {5, 4},
        };
        boolean result = validPath(n, edges, source, destination);
        System.out.println("result : " + result);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < edges.length; r++) {
            int src = edges[r][0];
            if (map.containsKey(src)) {
                map.put(src, map.get(src) + 1);
            } else {
                map.put(src, 1);
            }
        }

        boolean result = helper(n, edges, source, destination, visited, map);
        return result;

    }

    public static boolean helper(int n, int[][] edges, int source, int destination, boolean[] visited, Map<Integer, Integer> map) {
        if (source == destination) {
            return true;
        }

        if (map.containsKey(source) && map.get(source) == 1) {
            visited[source] = true;
        }

        for (int r = 0; r < edges.length; r++) {
            int sr = edges[r][0];
            if (sr == source) {
                source = edges[r][1];
                if (!visited[source]) {

                    boolean res = helper(n, edges, source, destination, visited, map);
                    return res;
                }
            }
        }

        return false;
    }
}
