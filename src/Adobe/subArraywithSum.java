package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class subArraywithSum {
    public static void main(String[] args) {
        int N = 10, S = 15;
        int[] A = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(subarraySum(A, N, S));
    }

    private static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();

        int cursum = arr[0];
        int idx = 0;

        for(int i = 1; i <= n; i++){
            while(cursum > s && idx < i - 1) {
                cursum -= arr[idx];
                idx++;
            }
            if(cursum == s) {
                ans.add(idx + 1);
                ans.add(i);
                return ans;
            }
            if(i < n){
                cursum+=arr[i];
            }
        }
        return ans;
    }
}
