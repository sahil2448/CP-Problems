
import java.util.Arrays;
import java.util.Scanner;

public class MinimalDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        int[] results = new int[t];

        for (int i = 0; i < t; i++) {

            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int x3 = scanner.nextInt();

            int[] points = {x1, x2, x3};
            Arrays.sort(points);

            int minimalDistance = (points[1] - points[0]) + (points[2] - points[1]);
            results[i] = minimalDistance;
        }

        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}
