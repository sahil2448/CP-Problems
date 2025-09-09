
import java.util.*;

public class RedVersusBlue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long r = sc.nextLong();
            long b = sc.nextLong();
            StringBuilder sb = new StringBuilder();

            long segments = b + 1;
            long minRedsPerSegment = r / segments;
            long remReds = r % segments;

            for (long i = 0; i < segments; i++) {
                for (long j = 0; j < minRedsPerSegment; j++) {
                    sb.append("R");
                }

                if (remReds > 0) {
                    sb.append("R");
                    remReds--;
                }

                if (i < b) {
                    sb.append("B");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
