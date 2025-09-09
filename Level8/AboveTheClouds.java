
import java.util.*;

public class AboveTheClouds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int freq[] = new int[26];

            for (int i = 0; i < n; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            boolean flag = false;
            for (int i = 1; i < n - 1; i++) {
                if (freq[s.charAt(i) - 'a'] > 1) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
