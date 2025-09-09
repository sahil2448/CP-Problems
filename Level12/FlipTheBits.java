
import java.util.*;

public class FlipTheBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            String a = sc.next();
            String b = sc.next();

            int zero = 0, one = 0;
            char[] arrA = a.toCharArray();
            char[] arrB = b.toCharArray();

            for (char c : arrA) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }

            boolean possible = true;
            boolean flipped = false;
            int zeros = 0, ones = 0;

            for (int i = n - 1; i >= 0; i--) {
                char curr = arrA[i];
                if (flipped) {
                    curr = (curr == '0') ? '1' : '0';
                }
                if (curr != arrB[i]) {
                    if (zero != one) {
                        possible = false;
                        break;
                    }
                    flipped = !flipped;
                }
                if (arrA[i] == '0') {
                    zero--;
                } else {
                    one--;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}
