package DSA.Arrays;

import java.util.*;

public class GravitySimulationCorrect {

    public static char[][] solution(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Apply gravity correctly column by column
        char[][] fallen = new char[rows][cols];
        for (int r = 0; r < rows; r++) Arrays.fill(fallen[r], '-');

        // Copy obstacles first
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == '*') {
                    fallen[r][c] = '*';
                }
            }
        }

        // Drop boxes down in each column
        for (int c = 0; c < cols; c++) {
            int bottom = rows - 1;
            for (int r = rows - 1; r >= 0; r--) {
                if (fallen[r][c] == '*') {
                    // Obstacle — boxes can only fall above this
                    bottom = r - 1;
                } else if (board[r][c] == '#') {
                    // Find the next available empty spot (not an obstacle)
                    while (bottom >= 0 && fallen[bottom][c] == '*') {
                        bottom--;
                    }
                    if (bottom >= 0) {
                        fallen[bottom][c] = '#';
                        bottom--;
                    }
                }
            }
        }

        // Step 2: Identify obstacles that will explode (if box directly above)
        boolean[][] willExplode = new boolean[rows][cols];
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (fallen[r][c] == '*' && fallen[r - 1][c] == '#') {
                    willExplode[r][c] = true;
                }
            }
        }

        // Step 3: Destroy all boxes in 3x3 area around exploding obstacles
        boolean[][] destroyed = new boolean[rows][cols];
        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (willExplode[r][c]) {
                    for (int k = 0; k < 9; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                            if (fallen[nr][nc] == '#') {
                                destroyed[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        // Step 4: Apply destruction
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (destroyed[r][c]) {
                    //fallen[r][c] = '-';
                }
            }
        }

        return fallen;
    }

    // Helper
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'#', '-', '#', '#', '*'},
                {'#', '-', '-', '#', '#'},
                {'-', '#', '-', '#', '-'},
                {'-', '-', '#', '-', '#'},
                {'#', '*', '-', '-', '-'},
                {'-', '-', '*', '#', '-'}
        };

        char[][] result = solution(board);
        printBoard(result);
    }
}
