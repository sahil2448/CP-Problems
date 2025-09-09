import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Q6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            ArrayList<Integer> b = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            TreeSet<Integer> s = new TreeSet<>();
            for (int i = 1; i <= n; i++) {
                s.add(i);
            }

            // Process the array
            for (int i = 0; i < n; i++) {
                if (s.contains(a[i])) {
                    b.add(a[i]); // Add the input value if available in the set
                    s.remove(a[i]); // Remove it from the set
                } else {
                    b.add(s.first()); // Add the smallest available value from the set
                    s.remove(s.first()); // Remove it from the set
                }
            }

            result.add(b); // Add the result for this test case
        }


        for (ArrayList<Integer> res : result) {
            for (int num : res) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
