
import java.util.HashMap;
import java.util.Scanner;

public class RockAndLever {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = a[i];

                for (int j = 30; j >= 0; j--) {
                    if ((num & (1 << j)) > 0) {
                        map.put(j, map.getOrDefault(j, 0) + 1);
                        break;
                    }
                }
            }

            long count = 0;
            for (int val : map.values()) {
                count += (long) val * (val - 1) / 2;
            }
            System.out.println(count);

        }

    }

}
