
import java.util.*;

public class MoveAndTurn {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = n / 2;

        if (n % 2 == 0) {
            System.out.println((k + 1) * (k + 1));
        } else {
            System.out.println(2 * (k + 1) * (k + 2));
        }

    }
}
