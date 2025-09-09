
import java.util.*;

public class MakeItZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr[i] = x;
            }
            if (n % 2 == 0) {
                System.out.println(2);
                System.out.print(1 + " ");
                System.out.println(n);
                System.out.print(1 + " ");
                System.out.println(n);
            } else {
                System.out.println(4);
                System.out.print(1 + " ");
                System.out.println(n - 1);
                System.out.print(1 + " ");
                System.out.println(n - 1);

                System.out.print(n - 1 + " ");
                System.out.println(n);
                System.out.print(n - 1 + " ");
                System.out.println(n);
            }
        }
    }
}
