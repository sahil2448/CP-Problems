import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int totalSeats = 2 * m;
            int seated = 0;

            int row1Seats = Math.min(a, m);
            seated += row1Seats;

            int row2Seats = Math.min(b, m);
            seated += row2Seats;

            int remainingRow1Seats = m - row1Seats;
            int remainingRow2Seats = m - row2Seats;

            int remainingC = c;
            int cInRow1 = Math.min(remainingC, remainingRow1Seats);
            seated += cInRow1;
            remainingC -= cInRow1;

            int cInRow2 = Math.min(remainingC, remainingRow2Seats);
            seated += cInRow2;

            result[i] = seated;
        }

        for (int res : result) {
            System.out.println(res);
        }

        sc.close();
    }
}
