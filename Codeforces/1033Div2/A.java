
import java.util.*;

public class A {

    /* simple record-like class */
    private static class Rect {

        int l, b;            

        Rect(int l, int b) {
            this.l = l;
            this.b = b;
        }
    }

    /* checks whether the three rectangles can tile a square */
    private static boolean canFormSquare(Rect[] r) {

        /* 1. total area must be a perfect square */
        int area = r[0].l * r[0].b + r[1].l * r[1].b + r[2].l * r[2].b;
        int s = (int) Math.round(Math.sqrt(area));
        if (s * s != area) {
            return false;
        }

        /* six permutations of the 3 rectangles */
        int[][] P = {
            {0, 1, 2}, {0, 2, 1},
            {1, 0, 2}, {1, 2, 0},
            {2, 0, 1}, {2, 1, 0}
        };

        for (int[] p : P) {
            Rect a = r[p[0]], b = r[p[1]], c = r[p[2]];

            /* strip partition – horizontal */
            if (a.b == s && b.b == s && c.b == s
                    && a.l + b.l + c.l == s) {
                return true;
            }

            /* strip partition – vertical */
            if (a.l == s && b.l == s && c.l == s
                    && a.b + b.b + c.b == s) {
                return true;
            }

            /* T-partition : a spans full width */
            if (a.l == s) {
                int rem = s - a.b;
                if (rem > 0) {
                    /* b & c side-by-side */
                    if (b.b == rem && c.b == rem
                            && b.l + c.l == s) {
                        return true;
                    }
                    /* b & c stacked */
                    if (b.l == s && c.l == s
                            && b.b + c.b == rem) {
                        return true;
                    }
                }
            }

            /* T-partition : a spans full height */
            if (a.b == s) {
                int rem = s - a.l;
                if (rem > 0) {
                    /* b & c stacked vertically */
                    if (b.l == rem && c.l == rem
                            && b.b + c.b == s) {
                        return true;
                    }
                    /* b & c side-by-side horizontally */
                    if (b.b == s && c.b == s
                            && b.l + c.l == rem) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            Rect[] rects = new Rect[3];
            for (int i = 0; i < 3; ++i) {
                int l = sc.nextInt();
                int b = sc.nextInt();
                rects[i] = new Rect(l, b);
            }
            out.append(canFormSquare(rects) ? "YES\n" : "NO\n");
        }
        System.out.print(out.toString());
    }
}
