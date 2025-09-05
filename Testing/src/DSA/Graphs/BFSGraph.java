package DSA.Graphs;

import java.util.*;

public class BFSGraph {
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

        BFSGraphTraversal sol = new BFSGraphTraversal();
        List<Integer> res = sol.bfs(adjList);
        System.out.println(Arrays.toString(res.toArray()));
    }

    static class BFSGraphTraversal {
        // Function to return Breadth First Search Traversal of given graph.
        public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
            // code here

            Queue<Integer> q = new LinkedList();
            ArrayList<Integer> ls = new ArrayList();
            boolean[] vis = new boolean[adj.size()];
            q.add(0);
            vis[0] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    ls.add(node);
                    for (int neighbour: adj.get(node)) {
                        if (!vis[neighbour]) {
                            q.add(neighbour);
                            vis[neighbour] = true;
                        }
                    }
                }

            return ls;
        }
    }
}
