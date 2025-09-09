
import java.util.*;

public class ThreeDecks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder out = new StringBuilder();
        while (T-- > 0) {
            long a = in.nextLong(), b = in.nextLong(), c = in.nextLong();
            long s = a + b + c;
            if (s % 3 != 0) {
                out.append("NO\n");
            } else {
                long t = s / 3;
                out.append((t >= b && t < c) ? "YES\n" : "NO\n");
            }
        }
        System.out.print(out);
    }
}
