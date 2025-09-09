
import java.util.*;

public class TwoDivisors {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (b % a == 0) {
                long mult = b / a; // p1--> smallest prime of x
                long x = b * mult;
                sb.append(x).append('\n');
            } else {
                long g = gcd(a, b);
                long x = (a / g) * b; // LCM(a,b) 
                sb.append(x).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
