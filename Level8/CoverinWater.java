// package LevelEightK;
import java.util.*;

public class CoverinWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            String s = sc.next();
            boolean threeConsecutiveDots = false;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (i + 1 < n && i + 2 < n) {
                    if (s.charAt(i) == '.' && s.charAt(i + 1) == '.' && s.charAt(i + 2) == '.') {
                        threeConsecutiveDots = true;
                    }
                }
                if (s.charAt(i) == '.') {
                    count++;
                }
            }

            if (threeConsecutiveDots) {
                System.out.println(2);
            } else {
                System.out.println(count);
            }
        }
    }
}
