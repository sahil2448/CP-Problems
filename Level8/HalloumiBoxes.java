// package LevelEightK;

import java.util.*;

public class HalloumiBoxes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int input[] = new int[n];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                input[i] = x;
                if (i != 0 && (input[i - 1] > input[i])) {
                    flag = false;
                }
            }

            if (flag == true) {
                System.out.println("YES");
            } else {
                if (k == 1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }

}
