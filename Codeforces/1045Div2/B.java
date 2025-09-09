
import java.util.*;

public class B {

    static final int[] PRIMES = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long g = 0;
            for (long num : a) {
                g = gcd(g, num);
            }
            if (g > 1) {
                for (int i = 0; i < n; i++) {
                    if (i > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(a[i]);
                }
                System.out.println();
                continue;
            }

            if (k % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    if (i > 0) {
                        System.out.print(" ");
                    }
                    if (a[i] % 2 == 0) {
                        System.out.print(a[i]);
                    } else {
                        System.out.print(a[i] + k);
                    }
                }
                System.out.println();
            } else {
                int p = 3;
                for (int candidate : PRIMES) {
                    if (k % candidate != 0) {
                        p = candidate;
                        break;
                    }
                }
                int kMod = (int) (k % p);
                int inv = 0;
                for (int i = 1; i < p; i++) {
                    if ((kMod * i) % p == 1) {
                        inv = i;
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    long r = a[i] % p;
                    if (r == 0) {
                        if (i > 0) {
                            System.out.print(" ");
                        }
                        System.out.print(a[i]);
                    } else {
                        long x = (p - r) * inv % p;
                        long value = a[i] + x * k;
                        if (i > 0) {
                            System.out.print(" ");
                        }
                        System.out.print(value);
                    }
                }
                System.out.println();
            }
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
