
import java.util.*;

public class Dances {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long a[] = new long[n];
            long b[] = new long[n];
            a[0] = m;

            for (int i = 1; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int ptr1 = n - 1;
            int ptr2 = n - 1;
            int count = 0;

            Arrays.sort(a);
            Arrays.sort(b);

            while (ptr1 >= 0 && ptr2 >= 0) {
                if (a[ptr1] < b[ptr2]) {
                    ptr1--;
                    ptr2--;
                    count++;
                } else if (a[ptr1] >= b[ptr2]) {
                    ptr1--;
                }
            }

            System.out.println(n - count);
        }
    }

}
