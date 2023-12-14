package Test;

public class TestCA {
    public static void main(String[] args) {
        /*char[][] mat = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };*/

       char[][] mat = {
                {'A', 'B' },
                {'S', 'F' }
        };

        String word = "ABD";
        //String word = "ABCDE";
        boolean result = false;
        char startCharacter = word.charAt(0);
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == startCharacter) {
                    result  = dfs(r, c, mat, word);
                    if (result) {
                        System.out.println("Word FOUND !!");
                        break;
                    }
                    counter = 0;
                }
            }
        }
        if(!result) System.out.println("Word Not Found !!");
    }

    private static int counter = 0;

    private static boolean dfs(int r, int c, char[][] mat, String word) {
        // base condition ..
        if (r >= mat.length || c >= mat[0].length) {
            return false;
        }
        if (counter == word.length()) {
            return true;
        }

        if ( mat[r][c] == word.charAt(counter)) {
            counter++;
        }

        boolean right = dfs(r, c + 1, mat, word);
        boolean bottom = dfs(r + 1, c, mat, word);

        return right || bottom;
    }
}
