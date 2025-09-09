import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine().trim();

            int countMinus = 0;
            int countUnder = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '-') {
                    countMinus++;
                } else if (c == '_') {
                    countUnder++;
                }
            }

            if (countUnder < 1 || countMinus < 2) {
                System.out.println(0);
            } else {
                long a = countMinus / 2;
                long b = countMinus - a;
                long result = (long) countUnder * a * b;
                System.out.println(result);
            }
        }

        scanner.close();
    }
}