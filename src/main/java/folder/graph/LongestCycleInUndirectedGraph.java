package folder.graph;

import java.util.ArrayList;
import java.util.List;

public class LongestCycleInUndirectedGraph {
    public static void main(String[] args) {

        List<List<Integer>> graph = new ArrayList<>();
        int nodes = 12;
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(4);

        graph.get(2).add(0);
        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(6);
        graph.get(4).add(1);

        graph.get(5).add(3);
        graph.get(5).add(6);
        graph.get(5).add(7);

        graph.get(6).add(4);
        graph.get(6).add(5);

        graph.get(7).add(5);
        graph.get(7).add(8);
        graph.get(7).add(9);

        graph.get(8).add(7);
        graph.get(8).add(11);

        graph.get(9).add(7);
        graph.get(8).add(10);

        graph.get(10).add(9);
        graph.get(10).add(11);

        graph.get(11).add(8);
        graph.get(11).add(10);

        boolean[] visited = new boolean[nodes];
        int parent = -1;
        for (int v = 0; v < nodes; v++) {
            if (!visited[v]) {
                cycle(v, visited, graph, "" + v, parent);
            }
        }
    }

    private static void cycle(int v, boolean[] visited, List<List<Integer>> graph, String psf, int parent) {

        visited[v] = true;
        List<Integer> nbrlist = graph.get(v);
        for (int nbr : nbrlist) {
            if (!visited[nbr]) {
                cycle(nbr, visited, graph, psf + nbr, v);
            } else if (parent != -1 && nbr != parent) {
                if (psf.length() > 1) {
                    System.out.println(psf);
                    psf = "";
                }
            }
        }
    }
}
