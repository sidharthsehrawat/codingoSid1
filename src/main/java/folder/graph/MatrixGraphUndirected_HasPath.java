package folder.graph;

public class MatrixGraphUndirected_HasPath {
    int[][] adj;
    int V;
    int E;

    public MatrixGraphUndirected_HasPath(int nodes) {
        this.adj = new int[nodes][nodes];
        this.V = nodes;
        this.E = 0;
    }

    public void addNodes(int src, int nbr) {
        adj[src][nbr] = 1;
        adj[nbr][src] = 1;
        E++;
    }

    public int[][] getgraph() {
        return adj;
    }

    public boolean hasPathDFS(int n, int[][] graph, int src, int dest,boolean[] visited ) {

        visited[src] = true;
        // base condition
        if (src == dest) {
            return true;
        }
        for (int c = 0; c < n; c++) {
            if (graph[src][c] == 1 && !visited[c]) {
                boolean result = hasPathDFS(n, graph, c, dest,visited);
                return result;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*

        0 - 1
        |   |
        3 - 2

        */

        MatrixGraphUndirected_HasPath matrixGraphHasPath = new MatrixGraphUndirected_HasPath(4);
        matrixGraphHasPath.addNodes(0, 1);
        matrixGraphHasPath.addNodes(1, 2);
        matrixGraphHasPath.addNodes(2, 3);
        matrixGraphHasPath.addNodes(3, 0);

        int[][] graph = matrixGraphHasPath.getgraph();
        boolean[] visited = new boolean[4];
        boolean result = matrixGraphHasPath.hasPathDFS(4, graph, 0, 1, visited);
        System.out.println("result path exist " + result);
    }
}
