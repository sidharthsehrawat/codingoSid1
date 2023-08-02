package folder.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraphTraversal {

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

    public static class Pair {
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
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

        // To-Do Code here...
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0 + ""));
        boolean[] visited = new boolean[vertex];

        while (queue.size() > 0) {
            Pair rem = queue.poll();

            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);

            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
}
