
import java.util.*;

public class DeletiveEditing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long test = sc.nextLong();

        while (test-- > 0) {
            String s = sc.next();
            String t = sc.next();
            int n = s.length();
            int m = t.length();

            int[] frequencyInT = new int[26];
            for (int i = 0; i < m; i++) { // m
                frequencyInT[t.charAt(i) - 'A']++;
            }

            char[] sArray = s.toCharArray();
            for (int i = n - 1; i >= 0; i--) { // n
                if (frequencyInT[sArray[i] - 'A'] > 0) {
                    frequencyInT[sArray[i] - 'A']--;
                } else {
                    sArray[i] = '.';
                }
            }

            StringBuilder finalString = new StringBuilder();
            for (int i = 0; i < n; i++) { // n
                if (sArray[i] != '.') {
                    finalString.append(sArray[i]);
                }
            }

            if (finalString.toString().equals(t)) { // m
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}

// tc = O(n+m) = O(30)
// sc = O(n+m+26+m) = O(n+m) = O(30)
