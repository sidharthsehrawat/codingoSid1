package folder.graph;

public class CountIslandInGraph {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0},
                {1, 0, 0, 1, 0}
        }; //5 x 5 mat || Count = 4 (no. of islands)
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        int count = getIsland(mat, visited);
        System.out.println(count);
    }

    private static int getIsland(int[][] mat, boolean[][] visited) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0 && visited[i][j] == false) {
                    countComponent(mat, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void countComponent(int[][] mat, boolean[][] visited, int i, int j) {

        if (i >= mat.length || i < 0 || j >= mat[i].length || j < 0 || visited[i][j] == true || mat[i][j] == 1) {
            return;
        }
        visited[i][j] = true;
        countComponent(mat, visited, i - 1, j);
        countComponent(mat, visited, i, j - 1);
        countComponent(mat, visited, i + 1, j);
        countComponent(mat, visited, i, j + 1);
    }
}
