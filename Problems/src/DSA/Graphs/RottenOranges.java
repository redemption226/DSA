package DSA.Graphs;/*
Given an n x m grid, where each cell has the following values :
2 - represents a rotten orange

1 - represents a Fresh orange

0 - represents an Empty Cell

Every minute, if a fresh orange is adjacent to a rotten orange in 4-direction ( upward, downwards, right, and left )
it becomes rotten.

Return the minimum number of minutes required such that none of the cells has a Fresh Orange.
If it's not possible, return -1.

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static class Pair {
        int first;
        int second;
        int time;

        Pair(int i, int j, int time){
            first = i;
            second = j;
            this.time = time;
        }
    }

    public static void main(String[] args) {

        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(rottenOranges(grid));

    }

    public static int rottenOranges(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m];
            Queue<Pair> q = new LinkedList<>();

            for (int i=0; i< n; i++) {
                for (int j=0 ; j<m; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new Pair(i,j,0));
                        vis[i][j] = 2;
                    }
                }
            }

            int time =0;
            while (!q.isEmpty()) {
                //-1, 0 | 0, 1 | 1, 0| 0, -1
                int[] delRow = {-1,0,1, 0};
                int[] delCol = {0, 1, 0, -1};

                Pair data = q.poll();
                int row = data.first;
                int col = data.second;
                int rotTime = data.time;

                time = Math.max(time, rotTime);

                for (int i= 0; i<4; i++) {
                    int newRow = row + delRow[i];
                    int newCol = col + delCol[i];

                    if (newRow >=0 && newRow < n && newCol>=0 && newCol <m &&
                            vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {

                        q.add(new Pair(newRow, newCol, rotTime+1));
                        grid[newRow][newCol] = 2;
                        vis[newRow][newCol] = 2;
                    }
                }
            }

            for (int i=0; i< n; i++) {
                System.out.println(Arrays.toString(grid[i]));
                for (int j=0; j<m; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return time;
        }
}
