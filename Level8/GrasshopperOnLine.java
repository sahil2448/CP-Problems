
import java.util.*;

public class GrasshopperOnLine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int k = sc.nextInt();

            if (x % k != 0) {
                System.out.println(1);
                System.out.println(x);
            } else {
                for (int i = 10; i > 0; i--) {
                    if (i % k != 0 && (x - i) % k != 0) {
                        System.out.println(2);
                        System.out.print(i +" ");
                        System.out.println(x-i);
                        break;
                    }
                }
            }
        }
    }
}
