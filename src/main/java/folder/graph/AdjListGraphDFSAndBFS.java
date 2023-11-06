package folder.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraphDFSAndBFS {
    List<List<Integer>> graph;
    int nodes;

    public AdjListGraphDFSAndBFS(int nodes) {
        this.nodes = nodes;
        graph = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3},
        };
        int source = 0;
        int destination = 2;
        int nodes = 6;
        AdjListGraphDFSAndBFS graph = new AdjListGraphDFSAndBFS(nodes);

        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }
        boolean[] visited = new boolean[nodes];
        boolean res = dfs(graph.graph, source, destination, visited);
        System.out.println("path exist : " + res);
    }

    private static boolean dfs(List<List<Integer>> graph, int source, int destination, boolean[] visited) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        List<Integer> nbrList = graph.get(source);
        for(int nbr : nbrList){
            if(!visited[nbr]){
                boolean res = dfs(graph, nbr, destination,visited);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
}
