
import java.util.*;

public class SequenceGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextInt();
            ArrayList<Long> b = new ArrayList<>();
            ArrayList<Long> a = new ArrayList<>();


            for (int i = 0; i < n; i++) {
                Long x = sc.nextLong();
                b.add(x);
            }
            a.add(b.get(0));
            for (int i = 1; i < n; i++) {
                if (b.get(i - 1) <= b.get(i)) {
                    a.add(b.get(i));
                } else {
                    a.add(b.get(i));
                    a.add(b.get(i));
                }
            }

            System.out.println(a.size());
            for (Long num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
