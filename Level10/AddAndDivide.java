
import java.util.*;

public class AddAndDivide {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            int minOps = Integer.MAX_VALUE;

            // Try incrementing b up to 30 times (enough for constraints)
            for (int inc = 0; inc <= 30; inc++) {
                long currB = b + inc;
                if (currB == 1) {
                    continue; // skip b == 1
                }
                long currA = a;
                int ops = inc; // number of b increments

                // Now divide until a == 0
                while (currA > 0) {
                    currA /= currB;
                    ops++;
                }
                minOps = Math.min(minOps, ops);
            }
            System.out.println(minOps);
        }
    }
}
