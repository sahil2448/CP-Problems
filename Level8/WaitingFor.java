
import java.util.Scanner;

public class WaitingFor {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long passangers = 0;
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            int num = sc.nextInt();

            if (ch == 'P') {
                passangers += num;
            } else {
                if (num > passangers) {
                    System.out.println("YES");
                    passangers = 0;
                } else {
                    System.out.println("NO");
                    passangers = passangers - num;

                }
            }
        }
    }
}
