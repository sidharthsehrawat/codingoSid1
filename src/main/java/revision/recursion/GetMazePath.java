
package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePath {
    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        List<String> ans = getMazePaths(0, 0, m, n);
        System.out.println("ans : " + ans);
    }

    private static List<String> getMazePaths(int i, int j, int m, int n) {
        if (i > m || j > n) {
            List<String> list = new ArrayList<>();
            return list;
        }

        if (i == m && j == n) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> ans = new ArrayList<>();
        List<String> hlist = getMazePaths(i + 1, j, m, n);
        List<String> vlist = getMazePaths(i, j + 1, m, n);

        for (String h : hlist) {
            ans.add(h + "h");
        }
        for (String v : vlist) {
            ans.add(v + "v");
        }

        return ans;
    }
}