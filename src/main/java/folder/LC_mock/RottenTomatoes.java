package folder.LC_mock;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatoes {


    private static class Pair {
        public int getHor() {
            return hor;
        }

        public int getVer() {
            return ver;
        }

        public int getMin() {
            return min;
        }

        int hor;
        int ver;
        int min;

        public Pair(int hor, int ver, int min) {
            this.hor = hor;
            this.ver = ver;
            this.min = min;
        }


    }

    public static void main(String[] args) {
    /*    int[][] grid = {{2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
        };

*/        int[][] grid = {{0,0,1,2},
                          {2,0,1,1}
                       };
        int mins = orangesRotting(grid);
        System.out.println(" ans =  " + mins);

    }

    private static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // store rotten fruit in queue for BFS..
                if (grid[i][j] == 2) {
                    Pair pair = new Pair(i, j, 0);
                    queue.add(pair);
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.getHor();
            int y = poll.getVer();
            int m = poll.getMin();
            //boundary condition..
            if (x > 0 || y > 0 || x < grid.length - 1 || y < grid[0].length - 1) {
                // top
                if (x > 0 && y>=0) {
                    if (grid[x - 1][y] == 1) {
                        grid[x - 1][y] = 2;
                        Pair pair = new Pair(x - 1, y, poll.getMin() + 1);
                        queue.add(pair);
                    }
                }

                // left
                if (x >= 0 && y > 0) {
                    if (grid[x][y - 1] == 1) {
                        grid[x][y - 1] = 2;
                        Pair pair = new Pair(x, y - 1, poll.getMin() + 1);
                        queue.add(pair);
                    }
                }

                // bottom
                if (x < grid.length-1  && y < grid[0].length) {
                    if (grid[x + 1][y] == 1) {
                        grid[x + 1][y] = 2;
                        Pair pair = new Pair(x + 1, y, poll.getMin() + 1);
                        queue.add(pair);
                    }
                }

                // right
                if (x < grid.length && y < grid[0].length-1) {
                    if (grid[x][y + 1] == 1) {
                        grid[x][y + 1] = 2;
                        Pair pair = new Pair(x, y + 1, poll.getMin() + 1);
                        queue.add(pair);
                    }
                }
            }

            ans = m;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] ==1){
                    return -1;
                }
            }
        }

        return ans;

    }


}
