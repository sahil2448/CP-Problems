
import java.util.Scanner;

public class PrefixMinAndSuffixMax {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int preMin[] = new int[n];
            int sufMax[] = new int[n];

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(arr[i], min);
                preMin[i] = min;
            }

            for (int i = n - 1; i >= 0; i--) {
                max = Math.max(arr[i], max);
                sufMax[i] = max;
            }

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < n; i++) {
                if (arr[i] == preMin[i] || arr[i] == sufMax[i]) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }

            System.out.println(sb.toString());
        }
    }
}
