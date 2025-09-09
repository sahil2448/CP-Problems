
import java.util.*;

public class MochaAndMath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (int i = 0; i < n; i++) {
                arr[(int) i] = sc.nextLong();
            }
            long min = arr[(int) 0];

            for (long i = 0; i < n; i++) {
                min = min & arr[(int) i];
            }

            System.out.println(min);

        }

    }
}
