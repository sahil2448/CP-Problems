
import java.util.*;

public class ThePickyCat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int num = Math.abs(a[0]);

            int newArr[] = new int[n];

            for (int i = 0; i < n; i++) {
                newArr[i] = Math.abs(a[i]);
            }

            Arrays.sort(newArr);

            if (newArr[n - 1] == num) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }
}
