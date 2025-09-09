import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[m];
            for (int j = 0; j < m; j++) {
                a[j] = sc.nextInt();
            }

            Set<Integer> knownQuestions = new HashSet<>();
            for (int j = 0; j < k; j++) {
                knownQuestions.add(sc.nextInt());
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                boolean canPass = true;

                for (int question = 1; question <= n; question++) {
                    if (question != a[j] && !knownQuestions.contains(question)) {
                        canPass = false;
                        break;
                    }
                }

                sb.append(canPass ? '1' : '0');
            }

            System.out.println(sb.toString());
        }

        sc.close();
    }
}
