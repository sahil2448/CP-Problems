
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            boolean ok = (((x & y) & ~z) == 0)
                    && (((x & z) & ~y) == 0)
                    && (((y & z) & ~x) == 0);

            sb.append(ok ? "YES" : "NO").append('\n');
        }
        System.out.print(sb.toString());
    }
}
