
import java.util.*;

public class PalindromeGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            String s = sc.next();
            int countZeros = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    countZeros++;
                }
            }

            if (countZeros % 2 == 0 || countZeros == 1) {
                System.out.println("BOB");
            } else {
                System.out.println("ALICE");
            }
        }
    }
}
