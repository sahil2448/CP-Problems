import java.util.*;
public class example2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int arr[] = new int[t];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int totalPersons = 0;
            int robin = 0;
            int gold[] = new int[n];
            for (int j = 0; j < n; j++) {
                gold[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                if (gold[j] >= k) {
                    robin += gold[j];
                } else if (gold[j] == 0 && robin > 0) {
                    robin -= 1;
                    totalPersons += 1;
                }
            }
            arr[i] = totalPersons;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(arr[i]);
        }
    }
}
