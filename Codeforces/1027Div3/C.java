
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (long i = 0; i < n; i++) {
                arr[(int) i] = sc.nextLong();
            }

            if (n == 1) {
                System.out.println(1);
                continue;
            }

            long ptr1 = 0;
            long ptr2 = 1;
            long count = 1;
            while (ptr2 < n) {
                if ((arr[(int) ptr1] + 1) < arr[(int) ptr2]) {
                    count++;
                    ptr1 = ptr2;
                }
                ptr2++;
            }

            System.out.println(count);
        }
    }
}
