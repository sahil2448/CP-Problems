import java.util.*;

public class ArrayMerging {

    public static void main(String[] args) {
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

            if (n == 1) {
                if (a[0] == b[0]) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
                continue;
            }

            int[] subA = new int[2 * n + 1];  
            int[] subB = new int[2 * n + 1];  

            int counter = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    counter++;
                } else {
                    subA[a[i - 1]] = Math.max(counter, subA[a[i - 1]]);
                    counter = 1;
                }
            }
            subA[a[n - 1]] = Math.max(counter, subA[a[n - 1]]);

            counter = 1;
            for (int i = 1; i < n; i++) {
                if (b[i] == b[i - 1]) {
                    counter++;
                } else {
                    subB[b[i - 1]] = Math.max(counter, subB[b[i - 1]]);  
                    counter = 1;
                }
            }
            subB[b[n - 1]] = Math.max(counter, subB[b[n - 1]]);  

            int finalAns = 0;  
            for (int i = 1; i <= 2 * n; i++) {
                finalAns = Math.max(finalAns, subA[i] + subB[i]);
            }

            System.out.println(finalAns);
        }
    }
}
