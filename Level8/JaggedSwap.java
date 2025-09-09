
import java.util.Scanner;

public class JaggedSwap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            if (arr[0] == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
