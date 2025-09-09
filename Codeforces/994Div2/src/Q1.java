import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1 {

    public static int mex(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int mex = 0;
        while (set.contains(mex)) {
            mex++;
        }
        return mex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int count = 0;
            boolean allZeros = true;
            for (int val : a) {
                if (val != 0) {
                    allZeros = false;
                    break;
                }
            }

            if (allZeros) {
                System.out.println(0);
                continue;
            }

            int firstNonZero = -1;
            int lastNonZero = -1;
            for(int i = 0; i < n; ++i){
                if(a[i] != 0){
                    if(firstNonZero == -1){
                        firstNonZero = i;
                    }
                    lastNonZero = i;
                }
            }

            if(firstNonZero == 0 && lastNonZero == n - 1){
                System.out.println(1);
            } else if (firstNonZero != 0 && lastNonZero != n-1){
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
        scanner.close();
    }
}