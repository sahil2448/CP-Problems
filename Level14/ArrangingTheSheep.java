
import java.util.*;

public class ArrangingTheSheep {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            String s = sc.next();
            long x = 0;
            long total;
            for (char ch : s.toCharArray()) {
                if (ch == '*') {
                    x++;
                }
            }
            total = x;
            long midPos = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    x--;
                }
                if (x == total / 2) {
                    midPos = i;
                    break;
                }
            }

            total = 0;
            long cnt = 0;
            long i = 0;
            while (i < midPos) {
                if (s.charAt((int) i) == '*') {
                    total += midPos - i - 1 - cnt;
                    cnt++;
                }
                i++;
            }

            cnt = 0;
            i = n - 1;

            while (i > midPos) {
                if (s.charAt((int) i) == '*') {
                    total += i - midPos - 1 - cnt;
                    cnt++;
                }
                i--;
            }

            System.out.println(total);
        }
    }
}
