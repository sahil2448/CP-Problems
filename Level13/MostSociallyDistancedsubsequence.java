
import java.util.*;

public class MostSociallyDistancedsubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n - 1 || (a[i - 1] < a[i]) != (a[i] < a[i + 1])) {
                    list.add(a[i]);
                }
            }

            System.out.println(list.size());
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();

        }
    }
}
