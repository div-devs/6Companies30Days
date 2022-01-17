package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/amend-the-sentence3235/1#
public class amendSentence {
    public static void main(String[] args) {
        String s = "BruceWayneIsBatman";
        System.out.println(amendSentence(s));
    }

    private static String amendSentence(String s) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        char[] input = s.toCharArray();
        for(char c : input) {
            if(c >= 65 && c <= 90) {
                if(index != 0) {
                    res.append((char) 32);
                }

                res.append((char)(c+32));
            }
            else {
                res.append(c);
            }

            index++;
        }

        return res.toString();
    }

}
