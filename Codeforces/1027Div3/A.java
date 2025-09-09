
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int year = Integer.parseInt(s);

            int sqrt = (int) Math.sqrt(year);

            if (sqrt * sqrt != year) {
                System.out.println(-1);
                continue;
            }

            boolean found = false;

            for (int a = 0; a <= sqrt; a++) {
                int b = sqrt - a;
                if (b >= 0) {
                    System.out.println(a + " " + b);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(-1);
            }
        }

    }
}
