package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/decode-the-string2444/1
public class decodeString {
    public static void main(String[] args) {
        String s = "3[b2[ca]]";
        System.out.println(decodedString(s));
    }

    private static int idx;
    private static String decodedString(String s){
        idx = 0;
        return helper(s);
    }

    private static String helper(String s) {
        StringBuilder ans = new StringBuilder();
        int repeat = 0;

        while (idx < s.length()) {

            char ch = s.charAt(idx);
            if (ch == ']') {
                return ans.toString();
            }

            else if (ch == '[') {
                ++idx;
                String str = helper(s);
                while (repeat > 0) {
                    ans.append(str);
                    --repeat;
                }
            }

            else if (Character.isDigit(ch)) {
                repeat = repeat * 10 + ch - '0';
            }

            else {
                ans.append(ch);
            }
            ++idx;
        }

        return ans.toString();
    }
}
