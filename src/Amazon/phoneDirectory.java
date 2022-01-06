package Amazon;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/phone-directory4628/1/
public class phoneDirectory {
    public static void main(String[] args) {
        int n = 3;
        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";

        System.out.println(displayContacts(n, contact, s));
    }

    private static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String str) {
        HashSet<String> set = new HashSet<>(Arrays.asList(contact));
        contact = new String[set.size()];

        int j = 0;

        for (String ele : set) {
            contact[j++] = ele;
        }

        Arrays.sort(contact);

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(new ArrayList<>());
        }

        for (String c : contact) {
            for (int i = 0; i < n; i++) {
                if (i < str.length() && str.charAt(i) == c.charAt(i)) {
                    result.get(i).add(c);
                }

                else {
                    break;
                }
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (result.get(i).size() == 0) {
                result.get(i).add("0");
            }
        }

        return result;
    }
}
