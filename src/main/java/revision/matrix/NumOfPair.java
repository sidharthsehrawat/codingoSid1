package revision.matrix;

import java.util.Arrays;

public class NumOfPair {
    public static void main(String[] args) {
        int[][] points = {
                {6, 2},
                {4, 4},
                {2, 6}};

        int res = numberOfPairs(points);
        System.out.println("ans " + res);
    }

    public static int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i][0];
                int y = points[i][1];

                int x1 = points[j][0];
                int y1 = points[j][1];

                if (x <= x1 && y > y1) {
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
