
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            String s = sc.next();

            int a = 0;
            int b = 0;
            while (arr[a] != 1) {
                a++;
            }
            while (arr[b] != n) {
                b++;
            }

            if (s.charAt(a) == '1' || s.charAt(b) == '1' || s.charAt(0) == '1' || s.charAt(n - 1) == '1') {
                System.out.println(-1);
                continue;
            }
            a++;
            b++;
            ArrayList<int[]> list = new ArrayList<>();
            list.add(new int[]{1, a});
            list.add(new int[]{1, b});
            list.add(new int[]{a, n});
            list.add(new int[]{b, n});
            list.add(new int[]{Math.min(a, b), Math.max(a, b)});

            System.out.println(5);
            for (int i = 0; i < 5; i++) {
                System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            }
        }
    }
}
