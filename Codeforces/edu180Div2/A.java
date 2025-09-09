
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if ((a < x && a < y) || (a > x && a > y)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
