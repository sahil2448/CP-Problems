import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int result[] = new int[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int sum = a + b + c;
            int days = 0;

            if (n <= a) {
                result[i] = 1;
            } else if (n <= a + b) {
                result[i] = 2;
            } else if (n <= a + b + c) {
                result[i] = 3;
            } else {
                int completeCycles = n / sum;
                int remaining = n % sum;

                days = completeCycles * 3;

                if (remaining > 0) {
                    if (remaining <= a) {
                        days += 1;
                    } else if (remaining <= a + b) {
                        days += 2;
                    } else {
                        days += 3;
                    }
                }
                result[i] = days;
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
        sc.close();
    }
}
