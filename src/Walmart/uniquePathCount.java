package Walmart;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/#
public class uniquePathCount {
    // TC: O(minimum(a,b) ; SC: O(1)
    public static void main(String[] args) {
        int A = 2, B = 2;
        System.out.println(NumberOfPath(A, B));
    }

    private static int NumberOfPath(int a, int b) {
        int ans = 1;
        int x= a + b - 2;

        int y = Math.min(a,b) - 1;

        for(int i = 1; i <= y; ++i) {
            ans = ans * (x - y + i) / i;
        }

        return ans;
    }
}
