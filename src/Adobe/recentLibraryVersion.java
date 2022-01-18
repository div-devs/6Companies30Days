package Adobe;
import java.util.*;

/*
    Given two library versions of an executable: for example,
    “10.1.1.3” and “10.1.1.9” or “10” and “10.1”.
    Find out which one is more recent? Strings can be empty also.
 */
public class recentLibraryVersion {
    public static void main(String[] args) {
        String s1 = "10.1";
        String s2 = "10";

        System.out.println(latest(s1, s2) == 0 ? "st1" : "st2");
    }

    private static int latest(String a, String b) {
        if(a.isEmpty() && b.isEmpty()) {
            return -1;
        }

        if(a.length() > b.length()) {
            return 0;
        }
        else if(a.length() < b.length()) {
            return 1;
        }
        int i = 0;
        while(a.charAt(i) == b.charAt(i)) {
            i++;
        }
        int st1 = helper(a.substring(i), 0);
        int st2 = helper(b.substring(i), 0);

        return st1 >= st2 ? 0 : 1;
    }

    private static int helper(String a, int max) {
        if(a.isEmpty()) {
            return max;
        }

        char ch = a.charAt(0);
        int num = ch -'0';
        if(num > max) {
            max = num;
        }
        return helper(a.substring(1), max);
    }


}
