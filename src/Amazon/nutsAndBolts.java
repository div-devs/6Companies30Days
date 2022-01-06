package Amazon;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1
public class nutsAndBolts {
    public static void main(String[] args) {
        int N = 5;
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};

        matchPairs(nuts, bolts, N);
        System.out.println(nuts);
        System.out.println(bolts);
    }

    private static void matchPairs(char[] nuts, char[] bolts, int n) {

        HashMap<Character,Integer> matchValue = new HashMap<>();
        for(int i=0;i<n;i++) {
            matchValue.put(nuts[i],i);
        }

        for(int i=0;i<n;i++) {
            if(matchValue.containsKey(bolts[i])) {
                nuts[i] = bolts[i];
            }
        }

        Arrays.sort(nuts);
        Arrays.sort(bolts);

    }
}
