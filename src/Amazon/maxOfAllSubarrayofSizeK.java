package Amazon;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
public class maxOfAllSubarrayofSizeK {
    public static void main(String[] args) {
        int N = 10, K = 4;
        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        System.out.println(max_of_subarrays(arr, N, K));
    }

    static ArrayList <Integer> max_of_subarrays(int[] arr, int n, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        int i;

        for(i=0;i<k;i++) {
            pq.add(arr[i]);
        }

        list.add(pq.peek());
        pq.remove(arr[0]);

        for(;i<n;i++) {
            pq.add(arr[i]);
            list.add(pq.peek());
            pq.remove(arr[i-k+1]);
        }

        return list;
    }
}
