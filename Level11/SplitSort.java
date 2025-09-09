
import java.util.*;

public class SplitSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int pos[] = new int[n + 1];

            for (int i = 0; i < n; i++) {
                pos[a[i]] = i;
            }

            int count = 0;

            for (int i = 1; i < n + 1; i++) {
                if (pos[i] < pos[i - 1]) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

}
