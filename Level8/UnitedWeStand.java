
import java.util.*;

public class UnitedWeStand {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != max) {
                    b.add(arr[i]);
                } else {
                    c.add(arr[i]);
                }
            }

            if (b.size() == 0) {
                System.out.println(-1);
            } else {
                System.out.print(b.size() + " ");
                System.out.println(c.size());
                for (int i : b) {
                    System.out.print(i + " ");
                }
                System.out.println();
                for (int j : c) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }

        }
    }
}
