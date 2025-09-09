
import java.util.*;

public class AB_Balance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        sc.nextLine();

        while (t-- > 0) {
            String str = sc.nextLine();
            int n = str.length();

            if (n == 1 || str.charAt(0) == str.charAt(n - 1)) {
                System.out.println(str);
            } else {
                if (str.charAt(0) == 'a') {
                    System.out.println('b' + str.substring(1));
                } else if (str.charAt(0) == 'b') {
                    System.out.println('a' + str.substring(1));
                }
            }
        }
    }
}
