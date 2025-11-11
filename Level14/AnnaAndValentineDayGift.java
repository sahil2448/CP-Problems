
import java.util.*;

public class AnnaAndValentineDayGift {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            List<long[]> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long num = a[i];
                int digitCount = 0;
                int zeros = 0;
                boolean flag = true;

                while (num > 0) {
                    if (num % 10 == 0 && flag) {
                        zeros++;
                    } else {
                        flag = false;
                        digitCount++;
                    }
                    num /= 10;
                }
                list.add(new long[]{a[i], digitCount, zeros});
            }

            list.sort(Comparator.comparingLong((long[] arr) -> arr[2]).reversed());

            long ans = 0;
            for (long[] arr : list) {
                ans += arr[1];
            }

            // add zrr for indices 1,3,5,... (i%2==1) after sorting descending
            for (int i = 0; i < list.size(); i++) {
                if ((i & 1) == 1) {
                    ans += list.get(i)[2];
                }
            }

            if (ans - 1 >= m) {
                System.out.println("Sasha");
            } else {
                System.out.println("Anna");
            }
        }
        sc.close();
    }
}
