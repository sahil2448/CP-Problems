
import java.util.*;

public class NumericStringTemplate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long a[] = new long[(int) n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            HashMap<Long, Long> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                freq.put(a[i], freq.getOrDefault(a[i], 0L) + 1);
            }

            long m = sc.nextLong();

            while (m-- > 0) {
                String s = sc.next();

                if (s.length() != n) {
                    System.out.println("NO");
                    continue;
                }

                HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    char ch = s.charAt(i);
                    hm.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
                }

                boolean ok = true;
                HashMap<Character, Long> charToNum = new HashMap<>();
                HashSet<Long> usedNums = new HashSet<>();

                for (Map.Entry<Character, ArrayList<Integer>> entry : hm.entrySet()) {
                    char ch = entry.getKey();
                    ArrayList<Integer> list = entry.getValue();
                    long num = a[list.get(0)];

                    for (int idx : list) {
                        if (a[idx] != num) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) {
                        break;
                    }

                    if (freq.get(num) != list.size()) {
                        ok = false;
                        break;
                    }

                    if (usedNums.contains(num)) {
                        ok = false;
                        break;
                    }

                    usedNums.add(num);
                    charToNum.put(ch, num);
                }

                System.out.println(ok ? "YES" : "NO");
            }
        }
    }
}
