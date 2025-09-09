
import java.util.*;

public class PermutationWarmUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int ans = Math.floorDiv(n * n, 4) + 1;

            System.out.println(ans);
        }
    }
}
