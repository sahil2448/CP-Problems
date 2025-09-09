
import java.util.*;

public class JoJosIncredibleAdventures {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            if (count == n) {
                System.out.println((long) n * n);
                continue;
            }

            s = s + s;
            int maxLen = 0;
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    len++;
                    maxLen = Math.max(maxLen, len);
                } else {
                    len = 0;
                }
            }

            long ans = 0;
            for (int i = 1; i <= maxLen; i++) {
                ans = Math.max(ans, (long) i * (maxLen - i + 1));
            }
            System.out.println(ans);
        }
    }
}
