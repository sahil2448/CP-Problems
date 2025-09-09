
import java.util.Scanner;

public class TwoPermutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (a == b && n == a) {
                System.out.println("YES");
                continue;
            }
            if (a + b + 2 <= n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
