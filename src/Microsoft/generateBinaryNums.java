package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1/
public class generateBinaryNums {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(generate(n));
    }

    public static ArrayList<String> generate(int N) {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();

        q.add("1");
        int cnt = 0;

        while(!q.isEmpty()){
            String rem = q.remove();
            ans.add(rem);
            cnt++;

            if(cnt == N) {
                return ans;
            }

            q.add(rem + "0");
            q.add(rem + "1");
        }

        return ans;
    }
}
