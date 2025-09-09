import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String singular = scanner.nextLine();

            String plural = singular.substring(0, singular.length() - 2) + "i";

            System.out.println(plural);
        }

        scanner.close();
    }
}