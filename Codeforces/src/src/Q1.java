import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        String[] result = new String[t];

        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for (int x = 0; x < arr.length; x++) {
                arr[x] = sc.nextInt();
            }

            boolean found = false;
            for (int i = 0; i < arr.length; i++) {
                boolean valid = true;
                for (int j = 0; j < arr.length; j++) {
                    if (i != j) {
                        int difference = Math.abs(arr[i] - arr[j]);
                        if (difference % k == 0) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid) {
                    result[z] = "YES\n" + (i + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[z] = "NO";
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
    }
}
