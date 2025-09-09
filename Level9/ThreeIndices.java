
import java.util.*;

public class ThreeIndices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long[] arr = new long[(int) n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            boolean flag = false;
            for (int i = 1; i < n - 1; i++) {
                if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                    flag = true;
                    System.out.println("YES");
                    System.out.println(i + " " + (i + 1) + " " + (i + 2));
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
            }
        }

    }
}
