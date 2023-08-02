package folder.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphHasCycleUN_DirectedBFS {
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
        int prev;
        String psf;


        public Pair(int v, int prev, String psf) {
            this.psf = psf;
            this.prev = prev;
            this.v = v;
        }
    }

    public static void main(String[] args) {

        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 10));

        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        // graph[2].add(new Edge(2, 5, 10));

        graph[4].add(new Edge(4, 3, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));

        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));

        graph[6].add(new Edge(6, 4, 10));
        graph[6].add(new Edge(6, 5, 10));


        int src = 0;

        for (int v = 0; v < vertex; v++) {
            if (visited[v] == false) {
                boolean cycle = hasCycle(graph, v, visited);
                if (cycle) {
                    System.out.println(cycle);
                }
                //System.out.println(cycle);
            }
        }
        //System.out.println(ans);
    }

    private static int ans = 0;

    private static boolean hasCycle(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1, src + ""));
        while (queue.size() > 0) {
            Pair rem = queue.poll();
            visited[rem.v] = true;

            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, e.src, rem.psf + e.nbr));
                    visited[e.nbr] = true;
                    rem.psf = rem.psf + e.nbr;
                } else {
                    if (visited[e.nbr] == true && rem.prev != -1 && rem.prev != e.nbr) {
                        rem.psf = rem.psf + e.nbr;
                        System.out.println(rem.psf);
                        return true;
                    }
                }
            }

        }
        return false;
    }
}