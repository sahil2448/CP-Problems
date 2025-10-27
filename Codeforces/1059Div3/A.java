
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int mx = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx, sc.nextInt());
            }
            sb.append(mx).append('\n');
        }
        System.out.print(sb.toString());
    }
}
