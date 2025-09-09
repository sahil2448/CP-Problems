// NAME : SAHIL YUVRAJ KAMBLE
// ENROLLMENT NO. : 23112087

import java.util.*;


public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            int k = n / 2;
            System.out.println((k + 1) * (k + 1));
        } else {
            int k1 = (n + 1) / 2;
            int k2 = (n - 1) / 2;
            System.out.println(2 * (k1 + 1) * (k2 + 1));
        }
    }
}
