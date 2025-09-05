package DSA.Graphs;

import java.util.*;

public class DFSGraph {
    public static void main(String[] args) {
        int[][] adj = {
                {2, 3, 1},
                {0},
                {0, 4},
                {0},
                {2}
        };

        // Convert to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < adj[i].length; j++) {
                list.add(adj[i][j]);
            }
            adjList.add(list);
        }

        DFSBFSGraphTraversal sol = new DFSBFSGraphTraversal();
        List<Integer> res = sol.dfsTrav(adjList);
        System.out.println(Arrays.toString(res.toArray()));
    }

    static class DFSBFSGraphTraversal {
        // Function to return Breadth First Search Traversal of given graph.
        public static ArrayList<Integer> dfsTrav(ArrayList<ArrayList<Integer>> adj) {
            // code here
            ArrayList<Integer> ls = new ArrayList();
            boolean[] vis = new boolean[adj.size()];
            return dfs(adj, vis, 0, ls);
        }

        public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int start, ArrayList<Integer> ls) {

                vis[start] = true;
                ls.add(start);

                for (int neigh : adj.get(start)) {
                    if (!vis[neigh]) {
                        dfs(adj, vis, neigh, ls);
                    }
                }


            return ls;
        }
    }
}
