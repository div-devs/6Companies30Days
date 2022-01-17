package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1/
public class arrAtoB {
    public static void main(String[] args) {
        int N = 5, M = 3;
        int[] A = {1, 2, 5, 3, 1};
        int[] B = {1, 3, 5};

        System.out.println(minInsAndDel(A, B, N, M));
    }

    private static int minInsAndDel(int[] A, int[] B, int N, int M) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<M;i++) {
            set.add(B[i]);
        }

        for(int i=0;i<N;i++) {
            if(set.contains(A[i]) ) {
                ans.add(A[i]);
            }
        }

        int l = longestIncreasingSubsequence(ans.stream().mapToInt(Integer::intValue).toArray());

        return (N - l) + (M - l);
    }


    private static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;

        }

        int[] tail = new int[n];
        int len = 1;
        tail[0] = arr[0];

        for (int i = 1; i < n; i++) {

            if (arr[i] > tail[len - 1]) {
                tail[len++] = arr[i];
            }

            else {
                int id = binarySearch(tail, 0, len-1, arr[i]);

                if (id < 0) {
                    id = (-1 * id) - 1;
                }
                tail[id] = arr[i];
            }
        }
        return len;
    }

    private static int binarySearch(int[] arr, int s, int e, int target) {
        while(s <= e) {
            int m = s + (e - s) >> 2;
            if(arr[m] < target) {
                s = m + 1;
            }

            else if(arr[m] > target) {
                e = m - 1;
            }

            else {
                return m;
            }
        }

        return -1;
    }
}
