package DSA.Graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraph {
    public static void main(String[] args) {
        int V = 4; // Number of vertices

        // Directed edges of the graph
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2,0 }, // This edge creates a cycle (0 → 2 → 0)
                { 2, 3 }
        };

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];

        for (int i=0 ;i<V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, adj, vis, pathVis)) {
                    System.out.println(true);
                    return;
                }
            }
        }

        System.out.println(false);
    }

    public static boolean detectCycle(int i, List<List<Integer>> adj, boolean vis[], boolean pathVis[])  {

        vis[i] = true;
        pathVis[i] = true;

        for (int neigh : adj.get(i)) {
            if (!vis[neigh]) {
                if (detectCycle(neigh, adj, vis, pathVis))
                        return true;
            }
            else if (pathVis[neigh]) {
                return true;
            }
        }
        pathVis[i] = false;
        return false;

    }


}
