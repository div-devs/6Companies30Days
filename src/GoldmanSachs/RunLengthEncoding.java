package GoldmanSachs;

// https://practice.geeksforgeeks.org/problems/run-length-encoding/1/
public class RunLengthEncoding {
    public static void main(String[] args) {
        String s = "aaaabbbccc";
        System.out.println(encode(s));
    }

    private static String encode(String str) {
        String ans = "";
        int i =1;
        int count = 1;

        while(str.length()>i) {

            if(str.charAt(i-1) == str.charAt(i)) {
                count++;
            }
            else {
                ans += str.charAt(i-1);
                ans += count;

                count = 1;
            }
            i++;
        }
        ans += str.charAt(i-1);
        ans += count;

        return ans;
    }
}
