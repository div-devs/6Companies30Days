package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1
public class sumAsPow {
    public static void main(String[] args) {
        int n = 100, x = 2;
        System.out.println(numOfWays(n, x));
    }

    private static int numOfWays(int n, int x) {
        ArrayList<Long> sq = sqFunc(n,x);

        long[][] dp = new long[n+1][sq.size()];
        for(long[] i : dp) {
            Arrays.fill(i,-1);
        }

        return (int)helper(sq,0, 0, n, dp);
    }

    private static ArrayList<Long> sqFunc(int n, int x) {

        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long) 1 );

        for(int i = 2; (int) Math.pow(i,x) <= n; i++) {
            long val = (long) Math.pow(i,x);
            arr.add(val);
        }
        return arr;
    }

    private static long helper(ArrayList<Long> squares, int index, long currsum, int target, long[][]dp) {
        if(currsum == target) {
            return 1;
        }

        if(currsum > target || index >= squares.size()){
            return 0;
        }

        if(dp[(int) currsum][index] != -1){
            return dp[(int)currsum][index];
        }

        long cnt = 0;
        cnt += helper(squares, index+1, currsum + squares.get(index), target,dp);
        cnt += helper(squares, index+1, currsum , target,dp);

        dp[(int)currsum][index] = cnt;

        return cnt;
    }
}
