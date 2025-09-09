
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            double num1 = Math.ceil(n / 2);
            double num2 = Math.ceil(m / 2);

            if (num1 == a || num1 == a + 1) {
                num1 = Math.ceil(Math.log(n) / Math.log(2));
            } else {
                num1 = Math.floor(Math.log(n) / Math.log(2));
            }
            if (num2 == b || num2 == b + 1) {
                num2 = Math.ceil(Math.log(m) / Math.log(2));
            } else {
                num2 = Math.floor(Math.log(m) / Math.log(2));
            }

            System.out.println(num1 + num2);

        }
    }
}
