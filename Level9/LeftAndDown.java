
import java.util.*;

public class LeftAndDown {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long k = sc.nextLong();

            if (a <= k && b <= k) {
                System.out.println(1);
            } else {
                long gcd = gcd(a, b);
                a = a / gcd;
                b = b / gcd;

                if (a <= k && b <= k) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }

            }
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

}
