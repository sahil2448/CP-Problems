
import java.util.*;

public class B {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            StringBuilder rev = new StringBuilder(s).reverse();
            if (s.equals(rev.toString())) {
                System.out.println(0);
                continue;
            }

            ArrayList<Integer> idx = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    idx.add(i + 1);
                }
            }

            System.out.println(idx.size());
            if (!idx.isEmpty()) {
                for (int i = 0; i < idx.size(); i++) {
                    if (i > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(idx.get(i));
                }
                System.out.println();
            }
        }
    }
}
