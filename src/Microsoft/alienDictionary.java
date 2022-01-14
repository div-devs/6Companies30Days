package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/alien-dictionary/1/
public class alienDictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};

        System.out.println(findOrder(dict, N, K));
    }

    public static String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i = 0; i < K; i++) {
            adj.add(i, new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {

            for(int j = 0; j < Math.min(dict[i].length(), dict[i+1].length()); j++) {

                if(dict[i].charAt(j)!=dict[i+1].charAt(j)) {

                    adj.get(dict[i].charAt(j)-'a').add(dict[i+1].charAt(j)-'a');
                    break;
                }

            }
        }
        return topologicalSort(adj, K);
    }

    public static String topologicalSort(ArrayList<ArrayList<Integer>> adj,int n) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];


        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfsCheck(adj,i,st,vis);
            }
        }

        StringBuilder str= new StringBuilder();

        while(!st.isEmpty()) {

            char c=(char)(st.pop()+'a');
            str.append(c);
        }

        return str.toString();

    }

    public static void dfsCheck(ArrayList<ArrayList<Integer>> adj, int i, Stack<Integer> st, boolean[] vis) {

        vis[i]=true;

        for(int it:adj.get(i)) {

            if(!vis[it]) {

                dfsCheck(adj,it,st,vis);
            }
        }
        st.push(i);
    }
}
