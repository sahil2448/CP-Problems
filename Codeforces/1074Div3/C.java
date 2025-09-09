
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            boolean aEven = a % 2 == 0;
            boolean bEven = b % 2 == 0;

            long ans = 0;

            if (aEven && bEven) {
                ans = (a * b / 2) + 2;
            } else if (!aEven && !bEven) {
                ans = a * b + 1;
            } else if (aEven && !bEven) {
                ans = -1;
            } else if (!aEven && bEven) {
                if ((b / 2) % 2 != 0) {
                    ans = -1;
                } else {
                    ans = (a * b / 2) + 2;

                }

            }

            System.out.println(ans);
        }
    }
}
