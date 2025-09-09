
import java.util.*;

public class CatCycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            k--;
            int floor = n / 2;
            System.out.println((k + (n % 2) * k / floor) % n + 1);
        }
    }
}
