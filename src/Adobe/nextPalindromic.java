package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1/
public class nextPalindromic {
    public static void main(String[] args) {
        String n = "35453";
        System.out.println(nextPalin(n));
    }

    public static String nextPalin(String N) {
        int n = N.length();
        if(n <= 3){
            return "-1";
        }
        StringBuilder str = new StringBuilder(N.substring(0, n/2));
        String temp = str.toString();
        String nextper = helper(str);


        if(nextper.compareTo(temp) <= 0) {
            return "-1";
        }

        String result = "";
        result += nextper;
        if(n % 2 != 0) {
            result += N.charAt(n/2);

            StringBuilder rev = new StringBuilder(nextper);
            rev.reverse();
            result += rev.toString();

        }

        else {

            StringBuilder rev = new StringBuilder(nextper);
            rev.reverse();
            result += rev.toString();
        }
        return result;
    }

    private static void swap(StringBuilder s, int i1, int i2) {
        char x = s.charAt(i1);
        s.setCharAt(i1, s.charAt(i2));
        s.setCharAt(i2, x);
    }

    private static void sort(StringBuilder sb, int index) {

        String temp = sb.substring(index);
        char[]arr = temp.toCharArray();
        Arrays.sort(arr);

        for(int i = 0; i < temp.length(); i++){
            sb.setCharAt(index + i, arr[i]);
        }
    }

    private static String helper(StringBuilder s) {
        int i1 = 0;

        for(int i = s.length() - 1; i > 0; i--){
            char x1 = s.charAt(i);
            char x2 = s.charAt(i - 1);

            if(x2 < x1){
                i1 = i - 1;
                break;
            }
        }
        int i2 = s.length() - 1;

        for(int i= i1 + 1; i < s.length(); i++) {

            char x1 = s.charAt(i);
            char x2 = s.charAt(i1);

            if(x1>x2){
                i2 = i;
            }
        }

        swap(s, i1, i2);
        sort(s, i1 + 1);

        return s.toString();
    }
}
