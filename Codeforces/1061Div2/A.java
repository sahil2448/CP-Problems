
import java.util.*;

public class A {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long ans = 0;

            while (n >= 3) {

                int m1 = n / 3;
                ans += m1;
                n -= m1;
                n -= (n / 2);
            }

            System.out.println(ans);
        }
    }
}
