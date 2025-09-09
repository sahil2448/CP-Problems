
import java.util.*;

public class TrafficLight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            char c = sc.next().charAt(0);

            String s = sc.next();

            s += s;
            n *= 2;

            long index = -1;
            long ans = 0;
            for (long i = n - 1; i >= 0; i--) {
                if (s.charAt((int) i) == 'g') {
                    index = i;
                } else if (s.charAt((int) i) == c) {
                    long diff = index - i;
                    ans = Math.max(ans, diff);
                }
            }

            System.out.println(ans);
        }
    }
}
