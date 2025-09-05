package DSA.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedBFS {

    public static class Pair {
        int child;
        int parent;
        Pair(int child, int parent) {
            this.child = child;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {
        int V = 8, E = 7;
        int[][] adjList = {{}, {2}, {1,3}, {2}, {5,6}, {4,6}, {4,5}, {8}, {7}};
        int n = adjList.length;
        boolean[] vis = new boolean[adjList.length];
        Queue<Pair> q  = new LinkedList<>();


        for (int i=1; i<n; i++) {
            if (!vis[i]) {
                q.add(new Pair(i, -1));
                vis[i] = true;

                while (!q.isEmpty()) {
                    Pair p = q.poll();

                    for (int node : adjList[p.child]) {
                        if (!vis[node]) {
                            vis[node] = true;
                            q.add(new Pair(node, p.child));
                        } else if (node != p.parent) {
                            System.out.println(true);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(false);

    }
}
