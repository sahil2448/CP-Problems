
import java.util.*;

public class DearrangedDeletions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean found = false;
            for (int i = 0; i < n && !found; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        System.out.println("YES");
                        System.out.println("2");
                        System.out.println(arr[i] + " " + arr[j]);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
