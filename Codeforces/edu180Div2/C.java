
import java.io.IOException;

public class C {

    private static final byte[] buffer = new byte[1 << 16];
    private static int len = 0, ptr = 0;

    private static int readByte() throws IOException {
        if (ptr >= len) {
            len = System.in.read(buffer);
            ptr = 0;
            if (len <= 0) {
                return -1;
            }
        }
        return buffer[ptr++];
    }

    private static int nextInt() throws IOException {
        int c, sign = 1, val = 0;
        do {
            c = readByte();
        } while (c <= ' ');
        if (c == '-') {
            sign = -1;
            c = readByte();
        }
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = readByte();
        }
        return val * sign;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = nextInt();
            }

            long ans = 0L;
            int aMax = a[n - 1];

            for (int k = 2; k < n; ++k) {
                int z = a[k];
                int M = Math.max(aMax, z << 1);
                int L = M - z;

                int left = 0, right = k - 1;
                while (left < right) {
                    if (a[left] + a[right] > L) {
                        ans += right - left;
                        --right;
                    } else {
                        ++left;
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
