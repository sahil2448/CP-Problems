
import java.util.Scanner;

public class UnitArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int freq = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x == -1) {
                    freq++;
                }
            }
            int count = 0;
            while ((freq > n / 2) || (freq % 2 != 0)) {
                count++;
                freq--;
            }

            System.out.println(count);
        }

    }
}
