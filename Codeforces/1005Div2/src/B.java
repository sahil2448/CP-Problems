import java.util.*;

public class B {
    public static void main(String args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int bestScore = -1;
            int bestL = 0;
            int bestR = 0;

            for (int l = 0; l <= n; l++) {
                for (int r = l; r <= n; r++) {
                    List<Integer> b = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if (i < l || i >= r) {
                            b.add(a[i]);
                        }
                    }

                    int score = b.size();
                    Set<Integer> distinct = new HashSet<>(b);
                    score -= distinct.size();

                    if (score > bestScore || (score == bestScore && b.size() < n - (r - l))) {
                        bestScore = score;
                        bestL = l + 1;
                        bestR = r;
                    }
                }
            }

            if (bestL == 1 && bestR == 0) {
                System.out.println(0);
            } else {
                System.out.println(bestL + " " + bestR);
            }
        }
    }
}