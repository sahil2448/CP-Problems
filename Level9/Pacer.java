
import java.util.*;

public class Pacer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int px = 0, py = 0;
            int points = 0;
            while (n-- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points += x - px;
                if (((x - px + 2) % 2) != ((y - py + 2) % 2)) {
                    points--;
                }
                px = x;
                py = y;
            }
            if (px != m) {
                points += m - px;
            }
            System.out.println(points);
        }

    }
}
