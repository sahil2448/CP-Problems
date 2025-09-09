import java.util.Scanner;

public class Z {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int rowDist = Math.max(a - 1, n - a);
            int colDist = Math.max(b - 1, m - b);
            System.out.println(Math.max(rowDist, colDist) + 1);
        }
        scanner.close();
    }
}
