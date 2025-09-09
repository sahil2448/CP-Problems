
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            int count = 0;

            n = n - k;
            count++;
            k--;
            count += (n / k);
            if (n % k != 0) {
                n = n % k;
                count++;
            }

            System.out.println(count);
        }
    }
}
