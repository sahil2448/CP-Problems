// NAME : SAHIL YUVRAJ KAMBLE
// ENROLLMENT NO. : 23112087
import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n+1];
        for (int i = 2; i <= n; i++) p[i] = sc.nextInt();
        int[] c = new int[n+1];
        for (int i = 1; i <= n; i++) c[i] = sc.nextInt();
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (c[i] != c[p[i]]) ans++;
        }
        System.out.println(ans);
    }
}
