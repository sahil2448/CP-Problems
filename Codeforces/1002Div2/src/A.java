import java.util.*;


public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            HashSet<Integer> initialSums = new HashSet<>();
            for (int i = 0; i < n; i++) {
                initialSums.add(a[i] + b[i]);
            }

            if (initialSums.size() >= 3) {
                System.out.println("YES");
                continue; // Optimization: If already 3 distinct sums, no need to check further
            }

            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) { // Avoid redundant swaps
                    if (a[i] != a[j]) { // Check if swap is actually useful
                        HashSet<Integer> newSums = new HashSet<>();
                        for (int k = 0; k < n; k++) {
                            if (k == i) {
                                newSums.add(a[j] + b[k]);
                            } else if (k == j) {
                                newSums.add(a[i] + b[k]);
                            } else {
                                newSums.add(a[k] + b[k]);
                            }
                        }
                        if (newSums.size() >= 3) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) break;
            }

            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}