package folder.graph;

import java.util.ArrayList;

public class PrintPathGraph {

    public static class Edge {
        int src;
        int nbr;
        int weight;

        public Edge(int src, int nbr, int weight) {
            this.src = src;
            this.nbr = nbr;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {
        int vertex = 7; // 0 1 2 3 4 5 6.
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 10));
        graph[0].add(new Edge(0, 1, 10));

        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[4].add(new Edge(4, 3, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));

        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));

        graph[6].add(new Edge(6, 5, 10));
        graph[6].add(new Edge(6, 4, 10));
        int source = 0;
        int destination = 6;
        String psf = "";
        hasPath(graph, source, destination, visited, source + psf);

    }

    private static void hasPath(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited, String psf) {

        if (source == destination) {
            System.out.println(psf);
        }

        visited[source] = true;

        for (Edge edge : graph[source]) {
            if (!visited[edge.nbr]) {
                hasPath(graph, edge.nbr, destination, visited, psf + edge.nbr);
            }
        }

        visited[source] = false;

    }


}
