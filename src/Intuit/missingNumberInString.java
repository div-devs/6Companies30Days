package Intuit;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/find-the-missing-no-in-string/1/
public class missingNumberInString {
    public static void main(String[] args) {

        String s1 = "9899100102";
        String s2 = "1112141519";

        System.out.println(missingNumber(s1));
        System.out.println(missingNumber(s2));
    }

    private static int missingNumber(String s) {
        if(s.length() == 1) {
            return -1;
        }

        for(int i = 1; i <= Math.min(6, s.length()); i++) {

            int curr = Integer.parseInt(s.substring(0,i));
            int ans = miss(s.substring(i), curr, false);
            if(ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    private static int miss(String str, int prev, boolean check_flag) {
        if (str.isEmpty()) {
            if (check_flag) {
                return 0;
            }
            return -1;
        }
        if(check_flag) {
            String curr = "" + (prev + 1);
            if (str.startsWith(curr)) {
                return miss(str.substring(curr.length()), prev + 1, check_flag);
            }

            else {
                return -1;
            }
        }

        else {

            String curr = "" + (prev + 1);
            if (str.startsWith(curr)) {
                return miss(str.substring(curr.length()), prev + 1, check_flag);
            }

            else {
                curr = (prev + 2) + "";
                if (str.startsWith(curr)) {
                    if (miss(str.substring(curr.length()), prev + 2, true) == 0) {
                        return prev + 1;
                    }

                    else {
                        return -1;
                    }
                }

                else {
                    return -1;
                }
            }
        }
    }
}
