import java.util.*;

public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ans = new int[t];

        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            int count = 0;

            if (k == 1) {
                count += n;
            } else {
                while (n > 0) {
                    if (n < k) {
                        count += n;
                        break;
                    } else {
                        long power = 1;
                        while (power * k <= n) {
                            power *= k;
                        }
                        n -= power;
                        count++;
                    }
                }
            }
            ans[i] = count;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
    }
}
