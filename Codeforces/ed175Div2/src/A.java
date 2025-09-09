
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello  world");

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long total = 0;
            for (int r = 0; r < 3; r++) {
                if (n >= r) {
                    total += ((n - r) / 15) + 1;
                }
            }
            System.out.println(total);
        }

        scanner.close();
        
    }
}
