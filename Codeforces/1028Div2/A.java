
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long d = sc.nextLong();

            boolean win1 = (a > d - 1) && (c > d - 1);
            boolean win2 = (a > b - 1) && (b <= c);

            if (win1 || win2) {
                System.out.println("Gellyfish");
            } else {
                System.out.println("Flower");
            }
        }
    }
}
