package DSA.Arrays;

import java.util.*;



import java.util.*;

public class GravitySimulation {
    public static char[][] solution(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Repeat until no more explosions happen (gravity -> explosion -> gravity)
        while (true) {
            // 1️⃣ Apply gravity
            applyGravity(board, rows, cols);

            // 2️⃣ Detect explosions
            List<int[]> explosions = detectExplosions(board, rows, cols);

            // If no explosions, we are done
            if (explosions.isEmpty()) break;

            // 3️⃣ Apply explosions
            applyExplosions(board, explosions, rows, cols);
        }

        return board;
    }

    private static void applyGravity(char[][] board, int rows, int cols) {
        for (int c = 0; c < cols; c++) {
            int writeRow = rows - 1;
            for (int r = rows - 1; r >= 0; r--) {
                if (board[r][c] == '*') {
                    writeRow = r - 1;
                } else if (board[r][c] == '#') {
                    if (r != writeRow) {
                        board[writeRow][c] = '#';
                        board[r][c] = '-';
                    }
                    writeRow--;
                }
            }
        }
    }

    private static List<int[]> detectExplosions(char[][] board, int rows, int cols) {
        List<int[]> explosions = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == '#' && r + 1 < rows && board[r + 1][c] == '*') {
                    explosions.add(new int[]{r + 1, c});
                }
            }
        }
        return explosions;
    }

    /**
     * Apply explosions but treat obstacles '*' as blockers for diagonal propagation.
     * - orthogonal neighbors are affected normally
     * - diagonal neighbors are affected only if neither intervening orthogonal cell is '*'
     */
    private static void applyExplosions(char[][] board, List<int[]> explosions, int rows, int cols) {
        // offsets for 3x3 area around the obstacle center (including center)
        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        // We'll mark removals first (to ensure simultaneous explosions)
        boolean[][] remove = new boolean[rows][cols];

        for (int[] pos : explosions) {
            int r = pos[0], c = pos[1];
            for (int i = 0; i < 9; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (board[nr][nc] != '#') continue; // only boxes are destroyed

                int dR = nr - r;
                int dC = nc - c;

                // center (r,c) itself is an obstacle; it won't be '#' so skip
                if (dR == 0 || dC == 0) {
                    // orthogonal or same row/col: no special blocking, destroy the '#'
                    remove[nr][nc] = true;
                } else {
                    // diagonal neighbor: check if either orthogonal "between" cell is an obstacle '*'
                    // example: target (r+1,c+1) -> check (r+1,c) and (r,c+1)
                    int between1R = r + dR, between1C = c;    // (nr, c)
                    int between2R = r, between2C = c + dC;    // (r, nc)
                    boolean blocked = false;
                    if (board[between1R][between1C] == '*') blocked = true;
                    if (board[between2R][between2C] == '*') blocked = true;

                    if (!blocked) {
                        remove[nr][nc] = true;
                    }
                }
            }
        }

        // Apply removals (simultaneous)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (remove[i][j] && board[i][j] == '#') {
                    board[i][j] = '-';
                }
            }
        }
    }

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

        System.out.println("Before:");
        printBoard(board);

        char[][] result = solution(board);

        System.out.println("\nAfter:");
        printBoard(result);
    }
}

