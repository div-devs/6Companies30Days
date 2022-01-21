package Intuit;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/#
public class minSumPartition {
    public static void main(String[] args) {
        int N = 4;
        int[] arr = {1, 6, 11, 5};

        System.out.println(minDifference(arr, N));
    }

    private static int minDifference(int[] arr, int n) {
        if(n==0){
            return 0;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        int t = helperDP(arr,n,(sum/2));
        return Math.abs(t - (sum - t));
    }

    private static int helperDP(int[] nums,int N,int sum) {
        int[][] temp = new int[N+1][sum+1];

        for(int i = 0; i < N + 1; i++) {

            for(int j = 0; j < sum + 1; j++) {

                if(i==0 || j==0) {
                    temp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i< N + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {

                if(nums[i - 1] <= j) {

                    int x = nums[i-1]+temp[i-1][j-nums[i-1]];
                    int y = temp[i-1][j];

                    if(Math.abs(j-x) > Math.abs(j-y)) {
                        temp[i][j] = y;
                    }

                    else {
                        temp[i][j] = x;
                    }
                }

                else {
                    temp[i][j] = temp[i-1][j];
                }
            }
        }
        return temp[N][sum];

    }
}
