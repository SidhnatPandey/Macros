class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        boolean vis[] = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoSortUtil(adj, i, vis, list);
            }
        }
        Collections.reverse(list);
        return list;
    }
    public static void topoSortUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis, ArrayList<Integer> list) {
        vis[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!vis[neighbor]) {
                topoSortUtil(adj, neighbor, vis, list);
            }
        }
        list.add(curr);
    }
}