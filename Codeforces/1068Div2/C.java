
import java.io.*;
import java.util.*;

public class C {

    public static boolean checkMultiples(Set<Long> set, long num, long k, int n) {
        if (k / num > n) {
            return false;
        }
        for (long pdt = num; pdt <= k; pdt += num) {
            if (!set.contains(pdt)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long a[] = new long[n];
            Set<Long> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                set.add(a[i]);
            }

            int size = set.size();

            if (set.contains(1L) && checkMultiples(set, 1L, k, size)) {
                out.println(1);
                out.println(1);
                continue;
            }

            Set<Long> validCandidates = new HashSet<>();
            for (long x : set) {
                if (checkMultiples(set, x, k, size)) {
                    validCandidates.add(x);
                }
            }

            Set<Long> result = new HashSet<>();
            boolean possible = true;

            for (long x : set) {
                long smallestValid = -1;

                for (long j = 1; j * j <= x; j++) {
                    if (x % j == 0 && validCandidates.contains(j)) {
                        smallestValid = j;
                        break;
                    }
                }

                if (smallestValid == -1) {
                    for (long j = (long) Math.sqrt(x); j >= 1; j--) {
                        if (x % j == 0 && j * j != x) {
                            long largeDiv = x / j;
                            if (validCandidates.contains(largeDiv)) {
                                smallestValid = largeDiv;
                                break;
                            }
                        }
                    }
                }

                if (smallestValid == -1) {
                    possible = false;
                    break;
                }
                result.add(smallestValid);
            }

            if (!possible) {
                out.println(-1);
            } else {
                out.println(result.size());
                StringBuilder sb = new StringBuilder();
                for (long x : result) {
                    sb.append(x).append(" ");
                }
                out.println(sb.toString().trim());
            }
        }
        out.flush();
        out.close();
    }
}
