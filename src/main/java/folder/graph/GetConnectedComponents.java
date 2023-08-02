package folder.graph;

import java.util.ArrayList;

public class GetConnectedComponents {

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

        //graph[0].add(new Edge(0,3,10));
        graph[0].add(new Edge(0, 1, 10));

        // graph[3].add(new Edge(3,0,10));
        graph[3].add(new Edge(3, 2, 10));
        //graph[3].add(new Edge(3,4,10));

        graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1,2,10));

        // graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2, 3, 10));

        // graph[4].add(new Edge(4,3,10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));

        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));

        graph[6].add(new Edge(6, 5, 10));
        graph[6].add(new Edge(6, 4, 10));

        getConnectedComponents(graph, visited, vertex);

    }

    private static void getConnectedComponents(ArrayList<Edge>[] graph, boolean[] visited, int vertex) {
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int v = 0; v < vertex; v++) {
            if (visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                getComponentList(graph, v, visited, comp);
                comps.add(comp);
            }
        }
        System.out.println(comps);

    }

    private static void getComponentList(ArrayList<Edge>[] graph, int source, boolean[] visited, ArrayList<Integer> comp) {
        visited[source] = true;
        comp.add(source);
        for (Edge edge : graph[source]) {
            if (visited[edge.nbr] == false) {
                getComponentList(graph, edge.nbr, visited, comp);
            }
        }
    }


}
