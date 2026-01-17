package DSA.Arrays;



import java.util.*;

public class TetrisGrid {
    public static int[][] solution(int n, int m, char[] figures) {
        int[][] grid = new int[n][m];

        // define figure shapes
        Map<Character, int[][]> shapes = new HashMap<>();
        shapes.put('A', new int[][]{{1}});
        shapes.put('B', new int[][]{{1, 1, 1}});
        shapes.put('C', new int[][]{{1, 1}, {1, 1}});
        shapes.put('D', new int[][]{{1, 0}, {1, 1}, {1, 0}});
        shapes.put('E', new int[][]{{0, 1, 0}, {1, 1, 1}});

        for (int index = 0; index < figures.length; index++) {
            int id = index + 1;
            char fig = figures[index];
            int[][] shape = shapes.get(fig);
            int h = shape.length, w = shape[0].length;

            // drop shape left aligned
            int colStart = 0; // can be adjusted if needed
            int rowPos = 0;

            // find lowest row where shape can land
            while (canFall(grid, shape, rowPos + 1, colStart, n, m)) {
                rowPos++;
            }

            // place shape
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (shape[i][j] == 1) {
                        grid[rowPos + i][colStart + j] = id;
                    }
                }
            }
        }

        return grid;
    }

    private static boolean canFall(int[][] grid, int[][] shape, int newRow, int col, int n, int m) {
        int h = shape.length, w = shape[0].length;
        if (newRow + h > n) return false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (shape[i][j] == 1 && grid[newRow + i][col + j] != 0)
                    return false;
            }
        }
        return true;
    }

    // For debugging
    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        char[] figures = {'D', 'B', 'A', 'C'};
        int[][] res = solution(n, m, figures);
        printGrid(res);

        // Expected output:
        // [1, 2, 2, 2]
        // [1, 1, 3, 0]
        // [1, 4, 4, 0]
        // [0, 4, 4, 0]
    }
}

