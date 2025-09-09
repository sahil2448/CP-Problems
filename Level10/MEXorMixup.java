
import java.util.Scanner;

public class MEXorMixup {

    // THE ALTERNATE WAY FOR CALCULATING XOR TILL N IN LESS TIME COMPLEXITY:
    // STORE arr[i] --> xor from 0 to i;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long xor = xorTill(a - 1);
            if (xor == b) {
                System.out.println(a);
            } else if ((xor ^ b) != a) {
                System.out.println(a + 1);
            } else {
                System.out.println(a + 2);
            }
        }
    }

    public static long xorTill(long n) {
        long mod = n % 4;
        if (mod == 0) {
            return n;
        } else if (mod == 1) {
            return 1;
        } else if (mod == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }
}

// ALTERNATE WAY---PRECOMPUTATION
// import java.util.*;
// public class MEXorMixup {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         long p = 300000;
//         long xorTill[] = new long[(int) p];
//         long x = 0;
//         for (long i = 0; i < p; i++) {
//             x = x ^ i;
//             xorTill[(int) i] = x;
//         }
//         int t = sc.nextInt();
//         while (t-- > 0) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             long xor = xorTill[a - 1];
//             if (xor == b) {
//                 System.out.println(a);
//             } else if ((xor ^ b) != a) {
//                 System.out.println(a + 1);
//             } else {
//                 System.out.println(a + 2);
//             }
//         }
//     }

// }
