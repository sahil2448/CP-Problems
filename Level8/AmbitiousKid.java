
import java.util.Scanner;

public class AmbitiousKid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        Long min = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            Long x = sc.nextLong();
            min = Math.min(Math.abs(x), min);
            if (min == 0) {
                System.out.println(0);
                break;
            }
        }

        if (min != 0) {
            System.out.println(min);
        }
    }
}
