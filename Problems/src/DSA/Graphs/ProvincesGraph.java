package DSA.Graphs;

import java.util.ArrayList;
import java.util.List;

public class ProvincesGraph {
    public static void main(String[] args) {
        Sol sol = new Sol();

        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(sol.findCircleNum(isConnected));


    }

    static class Sol {
        public int findCircleNum(int[][] isConnected) {

            List<List<Integer>> adjList = new ArrayList();
            int n = isConnected.length;

            for (int u = 0; u < n; u++) {
                List<Integer> ls = new ArrayList();
                for (int v = 0; v < n; v++) {
                    if (isConnected[u][v] == 1)
                        ls.add(v);
                }
                adjList.add(ls);
            }

            boolean[] vis = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    count++;
                    dfs(i, adjList, vis);
                }
            }


            return count;

        }

        void dfs(int start, List<List<Integer>> adjList, boolean[] vis) {

            vis[start] = true;

            for (int node : adjList.get(start)) {
                if (!vis[node]) {
                    dfs(node, adjList, vis);
                }
            }
        }
    }
}
