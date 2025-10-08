
import java.util.*;

public class WOWFactor {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        long a = 0;
        long b = 0;
        long c = 0;
        for (long i = 0; i < s.length(); i++) {
            if (s.charAt((int) i) == 'o') {
                b += a;
            } else if (i > 0 && s.charAt((int) i - 1) == 'v') {
                a++;
                c += Ab;
            }
        }

        System.out.println(c);;
    }
}
