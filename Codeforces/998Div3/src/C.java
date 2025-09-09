import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] freq = new int[n + 1];

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                freq[num]++;
            }

            int score = 0;

            for (int i = 1; i <= n; i++) {
                int complement = k - i;

                if (complement > 0 && complement <= n) {
                    int pairs = Math.min(freq[i], freq[complement]);

                    if (i == complement) {
                        pairs /= 2;
                    }

                    score += pairs;
                    freq[i] -= pairs;
                    freq[complement] -= pairs;
                }
            }

            System.out.println(score);
        }
    }
}
