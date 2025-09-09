
import java.util.*;

public class B {

    public static boolean check(String s) {
        int n = s.length();
        int bal = 0;
        for (int i = 1; i + 1 < n; i++) {
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
            }
            if (bal < 0) {
                return true;
            }
        }
        return bal != 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        while (tt-- > 0) {
            String s = sc.next();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
    
}
