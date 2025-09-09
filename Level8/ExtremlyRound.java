import java.util.*;

public class ExtremlyRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            String s = Long.toString(n);
            int digits = s.length();
            long base = (long) Math.pow(10, digits - 1);
            
            long result = 9 * (digits - 1) + (n / base);
            System.out.println(result);
        }
    }
}
