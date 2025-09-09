
import java.util.*;

public class Multiply2Divide6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long twoCount = 0;
            long threeCount = 0;

            while (n > 0 && n % 2 == 0) {
                twoCount++;
                n /= 2;
            }

            while (n > 0 && n % 3 == 0) {
                threeCount++;
                n /= 3;
            }

            if (n > 1 || twoCount > threeCount) {
                System.out.println(-1);
            } else {
                System.out.println((threeCount - twoCount) + threeCount);
            }

        }

    }
}
