
import java.util.*;

public class AlyonaAndSquareJigsawPuzzle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i <= 99; i += 2) {
            set.add((long) (i * i));
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long sum = 0;
            long count = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
                if (set.contains(sum)) {
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
