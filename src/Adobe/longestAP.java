package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/longest-arithmetic-progression1019/1/
public class longestAP {
    public static void main(String[] args) {
        int N = 6;
        int[] set = {1, 7, 10, 13, 14, 19};

        System.out.println(lengthOfLongestAP(set, N));
    }

    private static int lengthOfLongestAP(int[] A, int n) {

        HashMap<Integer,Integer>[] dp = new HashMap[n];
        int ans  = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {

            dp[i] = new HashMap<>();
            int diff = 0;
            for(int j = 0; j < i; j++) {

                diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff,1)+1);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }

        return ans == Integer.MIN_VALUE ? 1 : ans;
    }
}
