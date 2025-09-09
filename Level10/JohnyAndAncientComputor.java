
import java.util.*;

public class JohnyAndAncientComputor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            // Ensure a >= b
            if (a < b) {
                long temp = a;
                a = b;
                b = temp;
            }

            long ops = 0;
            if (a % b != 0) {
                System.out.println(-1);
                continue;
            }
            long ratio = a / b;

            // Check if ratio is a power of 2
            if ((ratio & (ratio - 1)) != 0) { // gives 0 for power of 2 
                System.out.println(-1);
                continue;
            }

            while (ratio >= 8) {
                ratio /= 8;
                ops++;
            }
            while (ratio >= 4) {
                ratio /= 4;
                ops++;
            }
            while (ratio >= 2) {
                ratio /= 2;
                ops++;
            }
            System.out.println(ops);
        }
    }
}
