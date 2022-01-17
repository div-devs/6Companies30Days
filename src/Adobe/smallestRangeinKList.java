package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1/
public class smallestRangeinKList {
    public static void main(String[] args) {
        int N = 5, K = 3;
        int[][] KSortedArray = {{1, 3, 5, 7, 9},
            {0, 2, 4, 6, 8},
            {2, 3, 5, 7, 11}};

        System.out.println(Arrays.toString(findSmallestRange(KSortedArray, N, K)));
    }

    private static int[] findSmallestRange(int[][] arr, int n, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(new comp());

        int[] res = {0,1000000};

        int max = Integer.MIN_VALUE;

        for(int i = 0 ;i < k; i++) {

            int val = arr[i][0];
            int[] temp = {val, 0, i};
            max = Math.max(max, val);
            pq.add(temp);
        }

        while(true) {
            int[] min = pq.poll();
            if(res[1] - res[0] > max - min[0]) {
                res[1] = max;
                res[0] = min[0];
            }

            min[1]++;
            if(min[1] == n) {
                break;
            }

            if(arr[min[2]][min[1]] > max) {
                max = arr[min[2]][min[1]];
            }

            int[] temp = {arr[min[2]][min[1]] , min[1] , min[2]};
            pq.add(temp);
        }
        return res;
    }

    static class comp implements Comparator< int[]> {
        public int compare(int[] ar1 , int[] ar2){
            return ar1[0] - ar2[0];
        }
    }
}
