package Amazon;

// https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1/
public class colNameColNum {
    public static void main(String[] args) {
        long n = 28;
        System.out.println(colName(n));
    }

    private static String colName (long n) {
        StringBuilder ans = new StringBuilder();

        while(n > 0) {
            n--;
            long val = n % 26;

            char x = (char) (val + 65);

            ans.insert(0, x);
            n = n / 26;
        }

        return ans.toString();
    }
}
