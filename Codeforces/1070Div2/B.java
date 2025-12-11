
import java.util.*;

public class B {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            boolean zero = false;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    zero = true;
                    break;
                }
            }

            if (!zero) {
                System.out.println(0);
                continue;
            }

            String ss = s + s;
            int mx = 0;
            int curZeros = 0;

            for (int i = 0; i < ss.length(); i++) {
                if (ss.charAt(i) == '0') {
                    curZeros++;
                    if (curZeros > mx) {
                        mx = curZeros;
                    }
                } else {
                    curZeros = 0;
                }
            }

            if (mx > n) {
                mx = n;
            }
            System.out.println(mx);
        }

    }
}
