
import java.util.*;

public class ShohagLovesStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            boolean found = false;

            for (int i = 0; i + 1 < n; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    System.out.println(s.substring(i, i + 2));
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }

            for (int i = 0; i + 2 < n; i++) {
                char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
                if (a != b && a != c && b != c) {
                    System.out.println(s.substring(i, i + 3));
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }

            System.out.println(-1);
        }
    }
}
