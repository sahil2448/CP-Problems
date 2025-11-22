
import java.util.*;

public class Sliding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long r = sc.nextLong();
            long c = sc.nextLong();

            System.out.println((n - r) * (m - 1) + n * m - (r - 1) * m - c);
        }

    }
}
