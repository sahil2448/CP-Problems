
import java.util.*;

public class TwoFrogs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            String parA = a % 2 == 0 ? "even" : "odd";
            String parB = b % 2 == 0 ? "even" : "odd";

            if (parA.equals(parB)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
