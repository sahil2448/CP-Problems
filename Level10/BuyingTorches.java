
import java.util.*;

public class BuyingTorches {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long k = sc.nextLong();
            long sticksGainedPerTrade = (x - 1);
            long sticksNeeded = (k * y + k - 1);
            long StickstoMakeTorchWithCoals = k;
            long ops = (long) Math.ceilDiv(sticksNeeded, sticksGainedPerTrade) + StickstoMakeTorchWithCoals;

            System.out.println(ops);
        }
    }
}
