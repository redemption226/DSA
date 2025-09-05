package DSA.Graphs;

public class DetectCycleUndirectedGraphDFS {

    public static void main(String[] args) {
        int V = 8, E = 7;
        int[][] adjList = {{}, {2}, {1,3}, {2}, {5,6}, {4,6}, {4,5}, {8}, {7}};
        int n = adjList.length;
        boolean[] vis = new boolean[adjList.length];
        for (int i=1; i<n; i++) {
            if (!vis[i]) {
                if (findCycle(adjList, vis, i, -1)) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);

    }

    public static boolean findCycle(int[][] adjList, boolean[] vis , int start, int parent) {
        int n = adjList.length;

        vis[start] = true;

        for (int node : adjList[start]) {
            if (!vis[node] && node != parent) {
                if (findCycle(adjList, vis, node, start))
                    return true;
            }
            else if (node != parent)
                return true;
        }

        return false;
    }
}
