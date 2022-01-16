package Adobe;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/implement-atoi/1/
public class atoi {
    public static void main(String[] args) {
        String str = "123";

        System.out.println(atoiFunc(str));
    }

    private static int atoiFunc(String str) {

        boolean neg = str.charAt(0) == '-';
        int num = 0;

        int i = (neg) ? 1 : 0;

        for(; i < str.length(); i++) {

            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                num *= 10;
                num += ch - '0';
            }
            else {
                return -1;
            }
        }
        return neg ? -num : num;
    }
}
