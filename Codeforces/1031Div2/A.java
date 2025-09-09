
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long k = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long max = 0;

            long maxType1 = (k >= a) ? (k - a) / x + 1 : 0;
            long maxType2 = (k >= b) ? (k - b) / y + 1 : 0;

            long portions1 = 0;
            if (k >= a) {
                long cnt1 = (k - a) / x + 1;
                long temp = k - cnt1 * x;
                if (temp < 0) {
                    temp = 0;
                }
                long cnt2 = (temp >= b) ? (temp - b) / y + 1 : 0;
                portions1 = cnt1 + cnt2;
            }

            long portions2 = 0;
            if (k >= b) {
                long cnt2 = (k - b) / y + 1;
                long temp = k - cnt2 * y;
                if (temp < 0) {
                    temp = 0;
                }
                long cnt1 = (temp >= a) ? (temp - a) / x + 1 : 0;
                portions2 = cnt1 + cnt2;
            }

            max = Math.max(portions1, portions2);

            System.out.println(max);
        }
    }
}
