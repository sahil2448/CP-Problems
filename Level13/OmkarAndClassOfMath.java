
import java.util.*;

public class OmkarAndClassOfMath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean f = false;
            for (int i = 2; i <= n / i; i++) { // O(sqrt(n))
                if (n % i == 0) {
                    int k = n / i;
                    System.out.println(k + " " + (n - k));
                    f = true;
                    break;
                }
            }
            if (!f) {
                System.out.println(1 + " " + (n - 1));
            }
        }
        sc.close();
    }
}
