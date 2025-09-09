
import java.util.*;

public class OnlyOneDigit {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int x = sc.nextInt();

            int minDigit = x;
            int num = x;

            while (num > 0) {
                int curr = num % 10;
                minDigit = Math.min(minDigit, curr);
                num /= 10;
            }

            System.out.println(minDigit);
        }
    }
}
