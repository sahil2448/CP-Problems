
import java.util.*;

public class ServalAndMochaArray {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (gcd(arr[i], arr[j]) <= 2) {
                        flag = false;
                    }
                }

            }
            if (flag == true) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }
}
