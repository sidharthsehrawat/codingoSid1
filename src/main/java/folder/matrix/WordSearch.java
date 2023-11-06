package folder.matrix;

public class WordSearch {
    private static int index = 0;

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String word = "cde";

        boolean result = false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                visited[i][j] = false;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char startingCharacter = word.charAt(0);
                if (matrix[r][c] == startingCharacter && !visited[r][c]) {
                    result = findWord(matrix, r, c, word, visited);
                    if (result) {
                        System.out.println("word Found at starting index : (" + r + ", " + c + " )");
                        break;
                    }
                    index = 0;
                }
            }
        }
        if (!result) {
            System.out.println("WORD NOT FOUND !");
        }
    }
    private static boolean findWord(char[][] matrix, int r, int c, String word, boolean[][] visited) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || visited[r][c] ||  index>=word.length() || matrix[r][c]!=word.charAt(index)) {
            return false;
        }
        visited[r][c] =true;
        if (matrix[r][c] == word.charAt(index) ) {
            index++;
        }
        if (index == word.length()) {
            return true;
        }
        boolean top = findWord(matrix, r - 1, c, word, visited);
        boolean left = findWord(matrix, r, c - 1, word, visited);
        boolean bottom = findWord(matrix, r + 1, c, word, visited);
        boolean right = findWord(matrix, r, c + 1, word, visited);

        visited[r][c] =false;
        return top || left || bottom || right;
    }
}
