package folder.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GraphMoreOperations {

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

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(String psf, int wsf) {
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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
        int k = 3;
        int criteria = 40;
        moreOperations(graph, source, destination, visited, source + psf, k, 0, criteria);
        System.out.println("large  " + lpathwt + " path -> " + lpath);
        System.out.println("small  " + spathwt + " path -> " + spath);
        System.out.println("ciel  " + cpathwt + " path -> " + cpath);
        System.out.println("floor  " + fpathwt + " path -> " + fpath);
        System.out.println("kth Element  " + pq.peek().wsf + " path -> " + pq.peek().psf);


    }

    static int lpathwt = Integer.MAX_VALUE;
    static String lpath;
    static int spathwt = Integer.MIN_VALUE;
    static String spath;
    static int cpathwt = Integer.MAX_VALUE;
    static String cpath;
    static int fpathwt = Integer.MIN_VALUE;
    static String fpath;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();


    private static void moreOperations(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited, String psf, int k, int wsf, int criteria) {

        if (source == destination) {
            if (spathwt < wsf) {
                spathwt = wsf;
                spath = psf;
            }

            if (lpathwt > wsf) {
                lpathwt = wsf;
                lpath = psf;
            }

            if (wsf > criteria && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }

            if (wsf < criteria && wsf > fpathwt) {
                fpathwt = wsf;
                fpath = psf;
            }

            if (pq.size() < k) {
                pq.add(new Pair(psf, wsf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(psf, wsf));
                }
            }

        }

        visited[source] = true;

        for (Edge edge : graph[source]) {
            if (visited[edge.nbr] == false) {
                moreOperations(graph, edge.nbr, destination, visited, psf + edge.nbr, k, wsf + edge.weight, criteria);
            }
        }

        visited[source] = false;

    }


}
