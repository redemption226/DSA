package DSA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

//SC = O(n^2) + 0(n^2) // VistedArray, Stack or Queue space (If all are pushed at once max)
// TC = O(n^2) + O(n^2) * 4 // n^2 loop and dfs on all 4 neighbours at max, Although, each dfs will be called once.

public class NumberIslands {

    public static class Pair {
        public int first;
        public int second;

        public Pair(int i, int j) {
            first = i;
            second = j;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
  {'1','1','0','0','0'},
  {'1','1','0','0','0'},
  {'0','0','1','0','0'},
  {'0','0','0','1','1'}
};

        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int count =0;

        for (int i=0; i< n; i++) {
            for (int j=0; j<m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    //dfs(grid, vis, i, j, n, m);
                    bfs(grid, vis, i,j, n, m, q);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, boolean[][] vis, int i, int j, int n, int m) {

        if (i<0 || i>=n || j<0 || j >= m || vis[i][j] || grid[i][j] != '1')
            return;

        vis[i][j] = true;
        dfs(grid, vis, i+1, j, n, m);
        dfs(grid, vis, i, j+1,  n, m);
        dfs(grid, vis, i-1, j, n, m);
        dfs(grid, vis, i, j-1, n, m);
    }


    public static void bfs(char[][] grid, boolean[][] vis, int i, int j, int n, int m, Queue<Pair> q) {

        q.add(new Pair(i,j));
        vis[i][j] =  true;
        // 4 directions (up, down, left, right)
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair pair  = q.poll();
            int row = pair.first;
            int col = pair.second;

            for (int k=0; k<4; k++) {
                int newRow = row + dRow[k];
                int newCol = col + dCol[k];

                if (newRow >=0 && newRow <n && newCol >=0 && newCol <m && !vis[newRow][newCol] && grid[newRow][newCol] == '1') {
                    vis[newRow][newCol] =  true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }

    }
}
