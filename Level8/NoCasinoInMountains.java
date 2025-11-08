
import java.util.*;

public class NoCasinoInMountains {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int hikes = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {

                if (a[i] == 1) {
                    count = 0;
                    continue;
                }

                count++;

                if (count == k) {
                    hikes++;
                    count = 0;
                    i++;
                }
            }

            System.out.println(hikes);
        }
    }
}
