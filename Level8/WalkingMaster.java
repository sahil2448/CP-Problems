
import java.util.Scanner;

public class WalkingMaster {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int result[] = new int[t];
        int i = 0;

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            if (a == c && b == d) {
                result[i++] = 0;
            } else if (b == d) {
                if (a > c) {
                    result[i++] = a - c;
                } else {
                    result[i++] = -1;
                }
            } else if (d > b) {
                int yDist = d - b;
                int xNeeded = a + yDist;
                if (xNeeded >= c) {
                    int steps = yDist + (xNeeded - c);
                    result[i++] = steps;
                } else {
                    result[i++] = -1;
                }
            } else {
                // d < b, which is impossible
                result[i++] = -1;
            }
        }
        for (int x : result) {
            System.out.println(x);
        }
    }
}
