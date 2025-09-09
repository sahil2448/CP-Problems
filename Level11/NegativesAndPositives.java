
import java.util.*;

public class NegativesAndPositives {

    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[(int) n];

            long totalSum = 0;

            long countNegative = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] < 0) {
                    ++countNegative;
                    arr[i] = -arr[i];
                }
            }

            for (int i = 0; i < n; i++) {
                totalSum += arr[i];
            }

            if (countNegative % 2 == 0) {
                System.out.println(totalSum);
            } else {
                Arrays.sort(arr);
                totalSum -= 2 * arr[0];
                System.out.println(totalSum);
            }

        }
    }
}
