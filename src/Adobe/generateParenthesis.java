package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/
public class generateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(AllParenthesis(n));
    }

    private static List<String> AllParenthesis(int n) {

        List<String> res = new ArrayList<>();
        Helper(n, n, "", res);
        return res;
    }

    private static void Helper(int o, int c, String s, List<String> res) {
        if(o == 0 && c == 0) {
            res.add(s);
            return;
        }
        else if(o < 0 || c < 0) {
            return;
        }

        Helper(o - 1,c,s + "(",res);

        if(o < c) {
            Helper(o, c - 1, s + ")", res);
        }
    }
}
