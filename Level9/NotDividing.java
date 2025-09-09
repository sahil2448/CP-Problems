
import java.util.*;

public class NotDividing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    arr[i]++;
                }
            }

            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1] % arr[i] == 0) {
                    arr[i + 1]++;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
