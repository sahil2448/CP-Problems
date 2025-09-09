import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double result[] = new double[12];

        for (int i=0;i<12;i++){
            float h = sc.nextFloat();
            float t = sc.nextFloat();

            double U = 55919/((110-t)*h);
            result[i] = U;

            System.out.println();
        }

        for (int i=0;i<12;i++){
            System.out.println(result[i]);
        }
    }
}
