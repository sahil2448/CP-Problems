
import java.util.Scanner;

public class MakeItPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            System.out.println(n - 1); // Number of operations
            for (int i = 2; i <= n; i++) {
                // Reverse the prefix [1, i] in row i
                System.out.println(i + " 1 " + i);
            }
        }
        sc.close();
    }
}
