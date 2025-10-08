
import java.util.*;

public class BalancedTunnel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        int pos[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int car = sc.nextInt();
            pos[car] = i;
        }

        int fined = 0;
        int maxExitPos = -1;

        for (int i = 0; i < n; i++) {
            int currentCar = a[i];
            if (pos[currentCar] < maxExitPos) {
                fined++;
            } else {
                maxExitPos = pos[currentCar];
            }
        }

        System.out.println(fined);
    }
}
