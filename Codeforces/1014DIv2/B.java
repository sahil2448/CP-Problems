
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            String a = sc.next();
            String b = sc.next();

            long OneAtOdd = 0;
            long OneAtEven = 0;
            long zeroAtOdd = 0;
            long zeroAtEven = 0;
            for (int i = 0; i < n; i++) {
                if ((i + 1) % 2 == 1 && a.charAt(i) == '1') {
                    OneAtOdd++;
                } else if ((i + 1) % 2 != 1 && a.charAt(i) == '1') {
                    OneAtEven++;
                }

                if ((i + 1) % 2 == 1 && b.charAt(i) == '0') {
                    zeroAtOdd++;
                } else if ((i + 1) % 2 != 1 && b.charAt(i) == '0') {
                    zeroAtEven++;
                }
            }
            if ((OneAtOdd <= zeroAtEven) && (OneAtEven <= zeroAtOdd)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
