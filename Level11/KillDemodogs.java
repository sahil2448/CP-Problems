import java.util.*;

public class KillDemodogs {

    static final int MOD = (int) 1e9 + 7;
    static final long INV6 = 166666668; // Modular inverse of 6 mod 1e9+7

    public static void solve(Scanner sc) {
        long n = sc.nextLong();

        long x = n % MOD;
        long part1 = (4 * x % MOD * x % MOD * x % MOD) % MOD; // 4 * n^3
        long part2 = (3 * x % MOD * x % MOD) % MOD;           // 3 * n^2
        long part3 = x;                                       // n

        long sum = (part1 + part2 - part3) % MOD;
        if (sum < 0) sum += MOD;

        long ans = sum * 2022 % MOD;
        ans = ans * INV6 % MOD;

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
