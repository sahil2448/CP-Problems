
import java.util.*;

public class TreasureHunt {

    public static void solve(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int a = sc.nextInt();

        if (a % (x + y) < x) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
