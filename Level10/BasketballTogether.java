
import java.util.*;

public class BasketballTogether {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D = sc.nextLong();
        long[] p = new long[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextLong();
        }
        Arrays.sort(p);

        int i = 0, j = N - 1;
        int count = 0;
        while (i <= j) {
            long k = D / p[j] + 1;
            if (j - i + 1 >= k) {
                count++;
                i += (int) (k - 1);
                j--;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
