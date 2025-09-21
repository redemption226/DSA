package LLD.SnakesAndLadders.Entities;

import java.util.Arrays;

public class Board {
    int[][] grid;

    public Board(int n) {
        grid = new int[n][n];
        int c = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j< n; j++) {
                grid[i][j] = c++;
            }
        }
    }

    void setEntity(int gridId) {

    }

    public void printState() {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
