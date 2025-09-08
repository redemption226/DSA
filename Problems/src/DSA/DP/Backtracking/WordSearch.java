package DSA.DP.Backtracking;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        return findWord( board,word, m , n );
    }

    public static boolean findWord(char[][] board, String word, int m, int n) {

        for (int i=0; i<m ; i++) {
            for (int j=0; j<n;j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean found =  searchWord(board, word, m,n,i,j,0, word.length());
                    if (found)
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean searchWord(char[][] board, String word, int m, int n, int i, int j, int k, int len) {

        if (k == len)
            return true;

        if (validate(board, word, m, n, i, j, k, len)) {
            char c = board[i][j];

            board[i][j] = '?';
            boolean right = searchWord(board, word, m,n, i, j+1, k+1, len);
            boolean left = searchWord(board, word, m,n, i, j-1, k+1, len);
            boolean up = searchWord(board, word, m,n, i-1, j, k+1, len);
            boolean down = searchWord(board, word, m,n, i+1, j, k+1, len);

            board[i][j] = c;
            return right || left || up || down;
        }
        return false;
    }

    public static boolean validate(char[][] board, String word, int m, int n, int i, int j, int k, int len) {
        if (i < 0 || i == m || j < 0 || j == n || word.charAt(k) != board[i][j] || board[i][j] == '?')
            return false;
        return true;
    }

}
