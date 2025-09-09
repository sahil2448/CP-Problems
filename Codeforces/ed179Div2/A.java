
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long n = x + 1;
            int leadingZeros = Long.numberOfLeadingZeros(n);
            int bitLength = 64 - leadingZeros;
            if (n > 0 && (n & (n - 1)) == 0) { // if n is a power of 2
                System.out.println(2 * (bitLength - 1) + 1); // 2(Number of bits)+1
            } else {
                System.out.println(2 * bitLength + 1); // 2(Number of bits)+1
            }
        }
    }
}
