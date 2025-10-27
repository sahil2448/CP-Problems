
import java.util.*;

public class D {

    static Scanner sc = new Scanner(System.in);
    static long query(int type, int l, int r) {
        System.out.println(type + " " + l + " " + r);
        System.out.flush();
        long x = sc.nextLong();
        return x;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long sum = query(2, 1, n);
            long triangle = (long) n * (n + 1) / 2;
            sum -= triangle;

            long diff = sum - 1;

            int l = 1, r = n;

            while (l < r) {
                int md = (l + r) / 2;
                long val1 = query(1, 1, md);
                long val2 = query(2, 1, md);

                if (val1 < val2) {
                    r = md;
                } else {
                    l = md + 1;
                }
            }

            System.out.println("! " + l + " " + (diff + l));
            System.out.flush();
        }
    }
}
