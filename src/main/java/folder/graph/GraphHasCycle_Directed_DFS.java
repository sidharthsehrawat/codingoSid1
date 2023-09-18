package folder.graph;

import java.util.ArrayList;

public class GraphHasCycle_Directed_DFS {
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
        int vertex = 10;
       // int vertex = 7;
        boolean[] visited = new boolean[vertex];
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 0, 10));
        //graph[3].add(new Edge(3, 4, 10));
        graph[4].add(new Edge(4, 6, 10));
        graph[5].add(new Edge(5, 6, 10));
        graph[6].add(new Edge(6, 5, 10));

       /* graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 7, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 6, 10));

        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 10));

        graph[4].add(new Edge(4, 3, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));

        graph[5].add(new Edge(5, 4, 10));
        // graph[4].add(new Edge(4, 6, 10));
        graph[6].add(new Edge(6, 2, 10));
        graph[6].add(new Edge(6, 4, 10));

        graph[7].add(new Edge(7, 1, 10));
        graph[7].add(new Edge(7, 8, 10));
        graph[7].add(new Edge(7, 9, 10));

        graph[8].add(new Edge(8, 7, 10));
        graph[8].add(new Edge(8, 9, 10));


        graph[9].add(new Edge(9, 7, 10));
        graph[9].add(new Edge(9, 8, 10));
*/
        for (int v = 0; v < vertex; v++) {
            if (visited[v] == false) {
                boolean hasCycle = hasCycleFunction(graph, v, visited, v + "");
                if (hasCycle)
                    System.out.println(hasCycle);
            }
        }
    }
    private static boolean hasCycleFunction(ArrayList<Edge>[] graph, int src, boolean[] visited, String psf) {
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
              hasCycleFunction(graph, e.nbr, visited, psf + e.nbr);
            } else if (visited[src] == true) {
                System.out.println(psf);
                return true;
            }
        }
        return false;
    }
}
