package GoldmanSachs;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/
// TC: O(Log Max(str1, str2)) ; SC: Constant {without Stack space required for gcd}
public class gcdOfStrings {
    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, gcdCalc(str1.length(), str2.length()));
    }

    private static int gcdCalc(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcdCalc(b, a%b);
    }
}
