package Microsoft;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/
public class wordsFromPhoneDigits {
    public static void main(String[] args) {
        int N = 3;
        int[] a = {2, 3, 4};
        System.out.println(possibleWords(a, N));
    }

    public static ArrayList<String> possibleWords(int[] a, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if(n == 0) {
            return ans;
        }


        helper(a,n,0,"",ans);
        return ans;
    }

    static String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void helper(int[] arr, int n, int index, String output, ArrayList<String> ans) {

        if (index >= n) {
            ans.add(output);
            return;
        }

        String temp = keypad[arr[index]];

        for (int i = 0; i < temp.length(); i++) {

            char ch = temp.charAt(i);
            helper(arr, n, index + 1, output + ch, ans);
        }
    }
}
