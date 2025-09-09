
import java.util.Scanner;

public class B {

    public static long ans(long n) {
        long cnt = 0;
        while (n > 1) {
            n = (n + 1) / 2;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            // Move a and b to the closer edge if beneficial
            if (n + 1 - a < a) {
                a = n + 1 - a;  // just above cut
            }
            if (m + 1 - b < b) {
                b = m + 1 - b; // just below cut
            }

            long option1 = 1 + ans(n) + ans(b);
            long option2 = 1 + ans(a) + ans(m);
            sb.append(Math.min(option1, option2)).append('\n');
        }
        System.out.print(sb);
        sc.close();
    }
}
