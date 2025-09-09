
import java.util.*;

public class CoinTransformation {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long ans = 1;
            while (n > 3) {
                ans *= 2;
                n = Math.floorDiv(n, 4);
            }
            System.out.println(ans);
        }
    }
}
