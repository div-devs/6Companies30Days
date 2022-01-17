package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/
public class arrayLeader {
    public static void main(String[] args) {
        int n = 6;
        int[] A = {16,17,4,3,5,2};

        System.out.println(leaders(A, n));
    }

    private static ArrayList<Integer> leaders(int[] arr, int n){
        ArrayList<Integer> res = new ArrayList<>();
        int maxYet = Integer.MIN_VALUE;

        for(int i = n - 1; i >= 0; i--) {

            if(arr[i] >= maxYet) {
                res.add(arr[i]);
            }

            maxYet = Math.max(maxYet,arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
