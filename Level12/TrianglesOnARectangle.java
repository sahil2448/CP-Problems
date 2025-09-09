
import java.util.*;

public class TrianglesOnARectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long w = sc.nextLong();
            long h = sc.nextLong();
            long ans = 0;
            for (int i = 0; i < 4; i++) {
                int k = sc.nextInt();
                long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
                for (int j = 0; j < k; j++) {
                    long val = sc.nextLong();
                    if (val < min) {
                        min = val;
                    }
                    if (val > max) {
                        max = val;
                    }
                }
                long base = max - min;
                long area = base * (i < 2 ? h : w);
                if (area > ans) {
                    ans = area;
                }
            }
            System.out.println(ans);
        }
    }
}
