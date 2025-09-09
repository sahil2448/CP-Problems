
import java.util.Scanner;

public class TargetPractice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Check if there is input available
        if (!sc.hasNextInt()) {
            System.out.println("No input provided.");
            return;
        }

        int t = sc.nextInt();

        while (t-- > 0) {

            char arr[][] = new char[10][10];

            for (int i = 0; i < 10; i++) {
                if (sc.hasNext()) {
                    String row = sc.next();
                    for (int j = 0; j < 10; j++) {
                        arr[i][j] = row.charAt(j);
                    }
                } else {
                    System.out.println("Insufficient input.");
                    return;
                }
            }

            int ans = 0;

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    char ch = arr[i][j];
                    if (ch == 'X') {
                        if (i == 0 || j == 0 || i == 9 || j == 9) {
                            ans += 1;
                        } else if (i == 1 || j == 1 || i == 8 || j == 8) {
                            ans += 2;
                        } else if (i == 2 || j == 2 || i == 7 || j == 7) {
                            ans += 3;
                        } else if (i == 3 || j == 3 || i == 6 || j == 6) {
                            ans += 4;
                        } else if (i == 4 || j == 4 || i == 5 || j == 5) {
                            ans += 5;
                        }
                    }
                }
            }

            System.out.println(ans);
        }
        sc.close();
    }
}
