
import java.util.Scanner;

public class B {

    private static long f(long x, long a) {
        long p = (x % a + a) % a;
        return p;
    }

    private static boolean check(long x11, long x22, long y11, long y22, long x1, long y1, long x2, long y2) {
        return (x11 == x22 && (x1 != x2 || y11 == y22))
                || (y11 == y22 && (y1 != y2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (tt-- > 0) {
            long w = sc.nextLong();
            long h = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();

            long x1l = f(x1, a);
            long x2r = f(x2, a);
            long y1l = f(y1, b);
            long y2r = f(y2, b);

            boolean result = check(x1l, x2r, y1l, y2r, x1, y1, x2, y2);
            sb.append(result ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
        sc.close();
    }
}
