
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            boolean blueCentered = ((n - b) % 2 == 0);
            boolean redIn = (a <= b);
            boolean redCentered = ((n - a) % 2 == 0);

            boolean possible = blueCentered && (redIn || redCentered);
            sb.append(possible ? "YES\n" : "NO\n");
        }
        System.out.print(sb.toString());
    }
}
