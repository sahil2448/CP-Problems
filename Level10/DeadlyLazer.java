
import java.util.*;

public class DeadlyLazer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int d = sc.nextInt();

            int leftDist = sx - 1;
            int rightDist = m - sy;
            int downDist = n - sx;
            int upDist = sy - 1;

            if (Math.min(leftDist, rightDist) <= d && Math.min(downDist, upDist) <= d) {
                System.out.println(-1);
            } else {
                System.out.println(n + m - 2);
            }
        }
    }
}
