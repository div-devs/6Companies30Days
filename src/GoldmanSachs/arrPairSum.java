package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
public class arrPairSum {
    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 3};
        int k = 6;

        System.out.println(canPair(arr, k));
    }

    private static boolean canPair(int[] nums, int k) {
        int[] rem = new int[k];

        for(int i : nums) {
            rem[i % k]++;
        }

        if(rem[0] % 2 != 0) {
            return false;
        }

        int i = 1, j = k - 1;
        while(i<j) {
            if(rem[i] != rem[j]) {
                return false;
            }
            i++;
            j--;
        }

        if(i==j && rem[i]%2 == 1) {
            return false;
        }

        return true;
    }
}
