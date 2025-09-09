
import java.util.*;

public class MinimumLCM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long ansA = 1;
            long ansB = n - 1;
            for (long fac = 2; fac * fac <= n; fac++) {
                if (n % fac == 0) {
                    ansA = n / fac;
                    ansB = n - ansA;
                    break;
                }
            }
            System.out.println(ansA + " " + ansB);
        }
    }
}
