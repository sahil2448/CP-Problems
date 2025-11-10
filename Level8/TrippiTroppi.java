
import java.util.*;

public class TrippiTroppi {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            char c = sc.next().charAt(0);

            System.out.println(a + "" + b + "" + c);
        }
    }
}
