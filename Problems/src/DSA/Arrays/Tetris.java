package DSA.Arrays;

import java.util.*;

public class Tetris {
    public static void main(String[] args) {
        char[][] board = {
                {'#', '-', '#', '#', '*'},
                {'#', '-', '-', '#', '#'},
                {'-', '#', '-', '#', '-'},
                {'-', '-', '#', '-', '#'},
                {'#', '*', '-', '-', '-'},
                {'-', '-', '*', '#', '-'}
        };
        simulate(board);
    }

    static void simulate(char[][] board) {
        int step = 0;
        System.out.println("Step " + step + " (initial):");
        print(board);

        while (true) {
            boolean moved = false;
            boolean explosionTriggered = false;

            char[][] snap = copy(board);
            char[][] next = emptyLike(board);

            // keep all bombs (*)
            for (int r = 0; r < board.length; r++)
                for (int c = 0; c < board[0].length; c++)
                    if (snap[r][c] == '*')
                        next[r][c] = '*';

            // PASS 1: mark all fall moves
            boolean[][] fall = new boolean[board.length][board[0].length];
            for (int r = board.length - 1; r >= 0; r--) {
                for (int c = 0; c < board[0].length; c++) {
                    if (snap[r][c] == '#') {
                        int below = r + 1;
                        if (below < board.length) {
                            if (snap[below][c] == '-') {
                                fall[r][c] = true;
                                moved = true;
                            } else if (snap[below][c] == '*') {
                                // will explode
                                explosionTriggered = true;
                            }
                        }
                    }
                }
            }

            // PASS 2: apply falls simultaneously
            for (int r = board.length - 1; r >= 0; r--) {
                for (int c = 0; c < board[0].length; c++) {
                    if (snap[r][c] == '#') {
                        if (fall[r][c]) {
                            next[r + 1][c] = '#';
                        } else if (next[r][c] == '-') {
                            next[r][c] = '#';
                        }
                    }
                }
            }

            if (moved) {
                step++;
                System.out.println("\nStep " + step + " (after fall):");
                print(next);
            }

            board = next;

            // EXPLOSION phase
            if (explosionTriggered) {
                boolean[][] remove = new boolean[board.length][board[0].length];
                for (int r = 0; r < board.length; r++) {
                    for (int c = 0; c < board[0].length; c++) {
                        if (snap[r][c] == '*' && r - 1 >= 0 && snap[r - 1][c] == '#') {
                            for (int dr = -1; dr <= 1; dr++) {
                                for (int dc = -1; dc <= 1; dc++) {
                                    int nr = r + dr, nc = c + dc;
                                    if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length)
                                        if (board[nr][nc] == '#')
                                            remove[nr][nc] = true;
                                }
                            }
                        }
                    }
                }

                for (int r = 0; r < board.length; r++)
                    for (int c = 0; c < board[0].length; c++)
                        if (remove[r][c])
                            board[r][c] = '-';

                step++;
                System.out.println("\nStep " + step + " (after explosion):");
                print(board);

                // settle after explosion
                boolean settling;
                do {
                    settling = false;
                    char[][] snap2 = copy(board);
                    char[][] next2 = emptyLike(board);
                    for (int r = 0; r < board.length; r++)
                        for (int c = 0; c < board[0].length; c++)
                            if (snap2[r][c] == '*')
                                next2[r][c] = '*';

                    boolean[][] fall2 = new boolean[board.length][board[0].length];
                    for (int r = board.length - 1; r >= 0; r--) {
                        for (int c = 0; c < board[0].length; c++) {
                            if (snap2[r][c] == '#') {
                                int below = r + 1;
                                if (below < board.length && snap2[below][c] == '-') {
                                    fall2[r][c] = true;
                                    settling = true;
                                }
                            }
                        }
                    }

                    for (int r = board.length - 1; r >= 0; r--) {
                        for (int c = 0; c < board[0].length; c++) {
                            if (snap2[r][c] == '#') {
                                if (fall2[r][c]) next2[r + 1][c] = '#';
                                else if (next2[r][c] == '-') next2[r][c] = '#';
                            }
                        }
                    }

                    if (settling) {
                        step++;
                        System.out.println("\nStep " + step + " (after settle fall):");
                        print(next2);
                    }
                    board = next2;
                } while (settling);
            }

            if (!moved && !explosionTriggered) {
                System.out.println("\n✅ Final stable:");
                print(board);
                break;
            }
        }
    }

    static char[][] emptyLike(char[][] b) {
        char[][] e = new char[b.length][b[0].length];
        for (char[] row : e) Arrays.fill(row, '-');
        return e;
    }

    static char[][] copy(char[][] b) {
        char[][] c = new char[b.length][b[0].length];
        for (int i = 0; i < b.length; i++)
            c[i] = Arrays.copyOf(b[i], b[i].length);
        return c;
    }

    static void print(char[][] board) {
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
    }
}
