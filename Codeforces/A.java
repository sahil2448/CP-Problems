
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean isConsistent = true;

            if (n == 2) {
                if (arr[0] + arr[1] != 1) {
                    isConsistent = false;
                }
            } else {
                int zeroWins = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == 0) {
                        zeroWins++;
                    }
                }

                if (zeroWins == 0) {
                    isConsistent = false;
                }

                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] == 0 && arr[i + 1] == 0) {
                        isConsistent = false;
                        break;
                    }
                }
            }

            System.out.println(isConsistent ? "NO" : "YES");
        }
    }

}
