package revision.recursion;

public class FloodFill {
    public static void main(String[] args) {
        int[][] maze = {
                {0,1,1,0},
                {0,0,0,0},
                {0,0,1,0},
                {0,0,0,0} // 3 ans...
        };
        int res = floodfillCount(maze);
        System.out.println("answer " + res);
    }

    private static int floodfillCount(int[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int row = 0;
        int col = 0;
       return helper(maze, visited, row, col, "");
    }

    private static int helper(int[][] maze, boolean[][] visited, int row, int col, String path) {
        if(row<0 || col>=maze[0].length || row>=maze.length || col<0 || visited[row][col] || maze[row][col] ==1){
            return 0;
        }
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(path);
            return 1;
        }
        visited[row][col] = true;
        int top = helper(maze,visited,row-1, col, path + "t");
        int left= helper(maze,visited,row, col-1, path + "l");
        int bottom = helper(maze,visited,row+1, col, path + "b");
        int right = helper(maze,visited,row, col+1,path + "r");
        visited[row][col] = false;
        return top+left+bottom+right;

    }
}
