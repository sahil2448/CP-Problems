
import java.util.Scanner;

public class OneAndTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int totalPdt = 1;
            int freq = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr[i] = x;
                totalPdt *= x;
                if (x == 2) {
                    freq++;
                }
            }

            if (freq == 0) {
                System.out.println(1);
            } else {
                int k = 1;
                boolean flag = false;
                int curr = 1;
                while (k <= n - 1) {
                    curr = curr * arr[k - 1];
                    int x = totalPdt / curr;
                    if (x == curr) {
                        System.out.println(k);
                        flag = true;
                        break;
                    }
                    k++;
                }
                if (flag != true) {
                    System.out.println(-1);
                }
            }
        }

    }
}
