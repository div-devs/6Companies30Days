package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1
public class bridgeEdgeGraph {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = 4;
        int E = 3;
        for (int i = 0; i < V + 1; i++) {
            list.add(i, new ArrayList<>());
        }

        int u = 0;
        int v = 1;
        list.get(u).add(v);
        list.get(v).add(u);
        u = 1; v = 2;
        list.get(u).add(v);
        list.get(v).add(u);
        u = 2; v = 3;
        list.get(u).add(v);
        list.get(v).add(u);

        int c = 1;
        int d = 2;

        System.out.println(isBridge(v, list, c, d));
    }

    public static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        return bfs(V, adj, c, d);
    }

    public static int bfs(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {

        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);

        vis[c] = true;

        adj.get(c).remove(d);
        adj.get(d).remove(c);

        while(!q.isEmpty()){
            int it = q.poll();

            for(Integer v: adj.get(it)) {
                if(!vis[v]) {
                    q.offer(v);
                    vis[v] = true;
                }
            }
        }

        if(vis[d]) {
            return 0;
        }

        return 1;
    }
}
