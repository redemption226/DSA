package DSA.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {

    public static void main(String[] args) {
        int n = 7;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 6}
        };

        List<Boolean> hasApple = new ArrayList<>(
                Arrays.asList(false, false, true, false, false, true, false)
        );

        System.out.println(minTime(n, edges, hasApple));
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        List<List<Integer>> adjList = new ArrayList();

        for (int i=0 ; i<n ; i++) {
            adjList.add(new ArrayList());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean vis[] = new boolean[n];

        return dfs(0, adjList, hasApple, vis);
    }

    public static int dfs(int i, List<List<Integer>> adjList, List<Boolean> hasApple, boolean vis[]) {

        int time = 0;
        vis[i] = true;

        for (int nei : adjList.get(i)) {
            if (!vis[nei])
                time += dfs(nei, adjList, hasApple, vis);
        }

        if ((time > 0 || hasApple.get(i)) && i != 0) return 2 + time;

        return time;
    }
}
