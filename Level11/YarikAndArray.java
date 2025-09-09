
import java.util.*;

public class YarikAndArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long mx = Long.MIN_VALUE;
            long sum = 0;
            int i = 0;
            int j = 0;

            while (j < n) {
                if (sum < 0) {
                    sum = 0;
                    i = j;
                }
                if (i < j) {
                    if (((arr[j] ^ arr[j - 1]) & 1) == 1) {
                        sum += arr[j];
                    } else {
                        sum = arr[j];
                        i = j;
                    }
                } else {
                    sum = arr[j];
                }

                mx = Math.max(mx, sum);
                j++;
            }

            System.out.println(mx);
        }
    }
}
