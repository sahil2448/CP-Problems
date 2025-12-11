
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int count = 0;
            int mx = sc.nextInt();
            for (int i = 1; i < n; i++) {
                int x = sc.nextInt();
                if (x < mx) {
                    count++;
                } else if (x > mx) {
                    mx = x;
                }
            }
            System.out.println(count);
        }
    }
}
