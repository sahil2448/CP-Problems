
import java.util.*;

public class RoofConstruction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            n--;
            int msb = (int) (Math.log(n) / Math.log(2));
            int pre = (int) Math.pow(2, msb) - 1;
            for (int i = pre; i >= 0; i--) {
                System.out.print(i + " ");
            }
            for (int i = pre + 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
