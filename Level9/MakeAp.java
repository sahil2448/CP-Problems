
import java.util.*;

public class MakeAp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();

            if (a == b && a == c) {
                System.out.println("YES");
                continue;
            }
            boolean flag = false;

            if ((2 * b - c) > 0 && (2 * b - c) % a == 0) {
                flag = true;
            }
            if ((2 * b - a) > 0 && (2 * b - a) % c == 0) {
                flag = true;
            }
            if ((a + c) > 0 && (a + c) % (2 * b) == 0) {
                flag = true;
            }

            if (flag == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
