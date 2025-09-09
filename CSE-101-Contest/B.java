// NAME : SAHIL YUVRAJ KAMBLE
// ENROLLMENT NO. : 23112087

import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        double p = sc.nextDouble();
        double ans = 0.5 + 0.5 * Math.pow(1 - 2 * p, n);
        System.out.printf("%.10f\n", ans);
    }
}
