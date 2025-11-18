
import java.util.*;

public class ProfitableInterestRate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (b <= a) {
                System.out.println(a);
            } else if (b > 2 * a) {
                System.out.println(0);
            } else {
                System.out.println(2 * a - b);
            }
        }
    }
}
