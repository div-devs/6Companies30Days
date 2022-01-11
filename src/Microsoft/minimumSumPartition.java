package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/
public class minimumSumPartition {
    public static void main(String[] args) {
        int N = 2;
        int[] arr = {1, 4};

        System.out.println(minDifference(arr, N));
    }

    public static int minDifference(int[] arr, int n) {

        Arrays.sort(arr);

        if(arr.length == 2) {
            return Math.abs(arr[0]-arr[1]);
        }
        int set1 = 0, set2;

        for(int i = 0;i < n-1; i++){
            set1 += arr[i];
        }
        set2 = arr[n-1];
        int min = Math.abs(set2 - set1);
        for(int i = n-2; i>=0;i--) {
            int check1= Math.abs(set1 - arr[i]), check2 = Math.abs(set2 + arr[i]);

            int newDiff = Math.abs(check1 - check2);

            if(newDiff < min) {

                set1 = check1;
                set2 = check2;
                min = newDiff;
            }
            else {
                return min;

            }
        }
        return min;
    }
}
