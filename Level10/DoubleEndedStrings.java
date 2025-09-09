
import java.util.*;

public class DoubleEndedStrings {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();

            long maxLen = 0;
            for (int i = 0; i < a.length(); i++) {
                for (int j = i + 1; j <= a.length(); j++) {
                    String sub = a.substring(i, j);
                    if (b.contains(sub)) {
                        maxLen = Math.max(maxLen, sub.length());
                    }
                }
            }

            System.out.println(a.length() + b.length() - (2 * maxLen));
        }
    }
}
