package Amazon;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/
public class iplMatchDay2 {
    public static void main(String[] args) {
        int N = 9, K = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(max_of_subarrays(arr, N, K));
    }

    static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {

        ArrayList<Integer> ans=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();

        for(int i=0;i<n;i++) {

            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i]){
                dq.removeLast();
            }

            dq.addLast(i);
            if(dq.getFirst() == i-k) {
                dq.removeFirst();
            }
            if(i >= k-1){
                ans.add(arr[dq.getFirst()]);
            }

        }
        return ans;
    }
}
