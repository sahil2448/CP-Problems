
import java.util.*;

public class CardboardForPictures {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            long n = sc.nextLong();
            long c = sc.nextLong();
            long arr[] = new long[(int) n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            long s = 0;
            long e = (long) 1e9;
            long ans = 0;
            while (s <= e) {
                long mid = s + (e - s) / 2;
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += (arr[i] + 2 * mid) * (arr[i] + 2 * mid);
                    if (sum > c) {
                        break;
                    }
                }
                if (sum <= c) {
                    ans = mid;
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

            System.out.println(ans);
        }

    }
}
