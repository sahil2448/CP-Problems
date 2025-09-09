
import java.util.*;

public class BeautifulArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long b = sc.nextLong();
            long s = sc.nextLong();

            long lastNum = k * b;

            if (lastNum > s || s > lastNum + n * (k - 1)) {
                System.out.println(-1);
                continue;
            }

            long[] arr = new long[(int) n];
            arr[(int) n - 1] = lastNum;

            long diff = s - lastNum;

            for (int i = 0; i < n && diff > 0; i++) {
                long add = Math.min(diff, k - 1);
                arr[i] += add;
                diff -= add;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
