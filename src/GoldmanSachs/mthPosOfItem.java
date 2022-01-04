package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/find-the-position-of-m-th-item1723/1
// kid with broken toy
public class mthPosOfItem {
    public static void main(String[] args) {
        int N = 5, M = 2, K = 1;
        System.out.println(findPosition(N, M, K));
    }

    private static int findPosition(int n, int m, int k) {
        if(n==1) {
            return 1;
        }

        int ans=m%n+k-1;
        if(ans==n) {
            return ans;
        }
        return ans % n;
    }
}
