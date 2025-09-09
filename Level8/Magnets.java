
import java.util.*;

public class Magnets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 1;

        int n = sc.nextInt();
        String prev = sc.next();

        for (int i = 0; i < n - 1; i++) {
            String curr = sc.next();
            if (!curr.equals(prev)) {
                count++;
            }
            prev = curr;
        }

        System.out.println(count);

    }
}
