
import java.util.*;

public class DifferentDivisors {

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void solve(Scanner sc) {
        int x = sc.nextInt();
        int p1 = 0, p2 = 0;

        for (int i = x + 1;; i++) {
            if (isPrime(i)) {
                p1 = i;
                break;
            }
        }
        for (int i = p1 + x;; i++) {
            if (isPrime(i)) {
                p2 = i;
                break;
            }
        }
        long prod1 = 1L * p1 * p2;
        long prod2 = 1L * p1 * p1 * p1;
        System.out.println(Math.min(prod1, prod2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
