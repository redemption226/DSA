package DSA.Arrays;

import java.util.*;

public class TetrisPattern {

    static int n, m;

    public static int[][] solution(int n, int m, char[] figures) {
        TetrisPattern.n = n;
        TetrisPattern.m = m;
        int[][] grid = new int[n][m];

        Map<Character, int[][]> shapes = getShapes();

        for (int idx = 0; idx < figures.length; idx++) {
            char f = figures[idx];
            int[][] shape = shapes.get(f);
            int id = idx + 1;
            placeFigure(grid, shape, id);
        }

        return grid;
    }

    private static void placeFigure(int[][] grid, int[][] shape, int id) {
        int shapeH = shape.length;
        int shapeW = shape[0].length;

        for (int col = 0; col <= m - shapeW; col++) {
            int row = 0;
            // Drop the piece down until it collides or reaches bottom
            while (canPlace(grid, shape, row + 1, col)) {
                row++;
            }

            // Place the piece
            if (canPlace(grid, shape, row, col)) {
                for (int i = 0; i < shapeH; i++) {
                    for (int j = 0; j < shapeW; j++) {
                        if (shape[i][j] == 1) {
                            grid[row + i][col + j] = id;
                        }
                    }
                }
                break;
            }
        }
    }

    private static boolean canPlace(int[][] grid, int[][] shape, int row, int col) {
        int shapeH = shape.length;
        int shapeW = shape[0].length;

        if (row + shapeH > n) return false;

        for (int i = 0; i < shapeH; i++) {
            for (int j = 0; j < shapeW; j++) {
                if (shape[i][j] == 1 && grid[row + i][col + j] != 0)
                    return false;
            }
        }
        return true;
    }

    private static Map<Character, int[][]> getShapes() {
        Map<Character, int[][]> shapes = new HashMap<>();

        shapes.put('A', new int[][]{
                {1}
        });

        shapes.put('B', new int[][]{
                {1, 1, 1}
        });

        shapes.put('C', new int[][]{
                {1, 1},
                {1, 1}
        });

        shapes.put('D', new int[][]{
                {1, 0},
                {1, 1},
                {1, 0}
        });

        shapes.put('E', new int[][]{
                {0, 1, 0},
                {1, 1, 1}
        });

        return shapes;
    }

    public static void print(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] res1 = solution(4, 4, new char[]{'D', 'B', 'A', 'C'});
        print(res1);

        System.out.println();

        int[][] res2 = solution(3, 5, new char[]{'A', 'D', 'E'});
        print(res2);
    }
}
