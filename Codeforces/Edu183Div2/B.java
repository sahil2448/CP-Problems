
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();

            int c0 = 0, c1 = 0, c2 = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    c0++;
                } else if (ch == '1') {
                    c1++;
                } else {
                    c2++;
                }
            }

            if (n == k) {
                for (int i = 0; i < n; i++) {
                    System.out.print('-');
                }
                System.out.println();
                continue;
            }

            int Lpos = c0 + 1;
            int Rpos = n - c1;
            int Ldef = c0 + c2 + 1;
            int Rdef = n - k + c0;

            StringBuilder result = new StringBuilder(n);
            for (int i = 1; i <= n; i++) {
                if (i < Lpos || i > Rpos) {
                    result.append('-');
                } else if (i >= Ldef && i <= Rdef) {
                    result.append('+');
                } else {
                    result.append('?');
                }
            }
            System.out.println(result.toString());
        }

        scanner.close();
    }
}
