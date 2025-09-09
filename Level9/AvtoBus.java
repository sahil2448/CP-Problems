
import java.util.*;

public class AvtoBus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();

            if (n < 4 || n % 2 == 1) {
                System.out.println(-1);
            } else {
                long min_buses = Math.ceilDiv(n, 6);
                long max_buses = n / 4;
                System.out.print(min_buses + " ");
                System.out.println(max_buses);
            }

        }
    }

}
