import java.util.*;

public class Osumania {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                arr[i] = s.indexOf('#') + 1;
            }

            for (int i = n - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
