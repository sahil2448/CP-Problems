
import java.io.*;
import java.util.*;

public class JumpingThroughSegments {

    static final int MAXN = 200000;
    static int[] segmentStart = new int[MAXN];
    static int[] segmentEnd = new int[MAXN];

    static boolean isReachableWithJump(int segmentCount, int maxJump) {
        int currentMinPosition = 0; // After i moves: minimal coordinate we can be at
        int currentMaxPosition = 0; // After i moves: maximal coordinate we can be at

        for (int i = 0; i < segmentCount; i++) {
            currentMaxPosition += maxJump; // expand reachable range to the right by k
            currentMinPosition -= maxJump; // expand reachable range to the left by k

            int reachableStart = Math.max(currentMinPosition, segmentStart[i]); // intersect with segment start
            int reachableEnd = Math.min(currentMaxPosition, segmentEnd[i]); // intersect with segment end

            if (reachableStart > reachableEnd) {
                return false; // empty intersection => can't land in this segment
            }
            currentMinPosition = reachableStart; // narrow range for the next step
            currentMaxPosition = reachableEnd;
        }

        return true; // all segments can be reached in order
    }

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1; // EOF

                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sgn = 1, x = 0;
            do {
                c = read();
            } while (c <= ' ' && c != -1); // skip whitespace
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * sgn;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int testCases = fs.nextInt();
        for (int tc = 0; tc < testCases; tc++) {
            int segmentCount = fs.nextInt();
            for (int i = 0; i < segmentCount; i++) {
                segmentStart[i] = fs.nextInt();
                segmentEnd[i] = fs.nextInt(); // segments must be visited in given order
            }

            int low = 0, high = 1_000_000_000; // binary search for minimal feasible k
            while (low < high) {
                int mid = (low + high) >>> 1; // candidate k (unsigned right shift to avoid overflow)
                if (isReachableWithJump(segmentCount, mid)) {
                    high = mid; // k works; try smaller
                } else {
                    low = mid + 1; // k too small; go higher
                }
            }

            out.append(low).append('\n'); // minimal k making the path possible
        }

        System.out.print(out.toString());
    }
}

/*
Time Complexity (TC): O(\sum n * log(1e9))
Space Complexity (SC): O(n) for storing segments
 */
