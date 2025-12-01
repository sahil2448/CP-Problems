
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();

            int yPairs = y / 2;
            int Players = n - r;
            int ySusp = Math.min(yPairs, Players);

            System.out.println(r + ySusp);
        }

    }
}
