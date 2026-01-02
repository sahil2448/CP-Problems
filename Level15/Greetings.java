
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Greetings {

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static class Pair {

        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class FenwickTree {

        int[] tree;

        FenwickTree(int size) {
            tree = new int[size + 2];
        }

        void add(int index, int delta) {
            for (int i = index; i < tree.length; i += i & -i) {
                tree[i] += delta;
            }
        }

        int sum(int index) {
            int result = 0;
            for (int i = index; i > 0; i -= i & -i) {
                result += tree[i];
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder output = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Pair(fs.nextInt(), fs.nextInt());
            }

            Arrays.sort(intervals, (p1, p2) -> Integer.compare(p1.start, p2.start));

            // Coordinate compression for b-values
            int[] ends = new int[n];
            for (int i = 0; i < n; i++) {
                ends[i] = intervals[i].end;
            }
            int[] sortedEnds = ends.clone();
            Arrays.sort(sortedEnds);

            int m = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || sortedEnds[i] != sortedEnds[i - 1]) {
                    sortedEnds[m++] = sortedEnds[i];
                }
            }

            FenwickTree fenwick = new FenwickTree(m + 2);
            long inversions = 0L;

            for (int i = 0; i < n; i++) {
                int rank = 1 + Arrays.binarySearch(sortedEnds, 0, m, intervals[i].end);
                int smallerCount = fenwick.sum(rank - 1);
                inversions += i - smallerCount;
                fenwick.add(rank, 1);
            }

            output.append(inversions).append('\n');
        }

        System.out.print(output);
    }
}
/*
Time Complexity (TC): O(nlogn)
Space Complexity (SC): O(n)
*/
