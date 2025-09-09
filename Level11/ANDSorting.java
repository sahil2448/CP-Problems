
import java.util.*;

public class ANDSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int ans = (1 << 30) - 1;
            for (int i = 0; i < n; i++) {
                if (a[i] != i) {
                    ans &= a[i];
                }
            }

            System.out.println(ans);

        }
    }

}
