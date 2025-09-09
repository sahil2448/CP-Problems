
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] fib = new int[11];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i <= 10; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] cubes = new int[n];
            for (int i = 0; i < n; i++) {
                cubes[i] = fib[n - i];
            }

            StringBuilder answer = new StringBuilder(m);
            for (int i = 0; i < m; i++) {
                int w0 = sc.nextInt();
                int l0 = sc.nextInt();
                int h0 = sc.nextInt();

                boolean canFitInThisBox = false;

                int[][] perms = {
                    {0, 1, 2},
                    {0, 2, 1},
                    {1, 0, 2},
                    {1, 2, 0},
                    {2, 0, 1},
                    {2, 1, 0}
                };
                int[] dims = new int[]{w0, l0, h0};

                for (int[] perm : perms) {
                    int baseW = dims[perm[0]];
                    int baseL = dims[perm[1]];
                    int height = dims[perm[2]];

                    if (height < cubes[0]) {
                        continue;
                    }

                    List<Rect> freeRectangles = new ArrayList<>();
                    freeRectangles.add(new Rect(baseW, baseL));

                    boolean fits2D = true;
                    for (int cubeSize : cubes) {
                        int pickedIndex = -1;
                        for (int k = 0; k < freeRectangles.size(); k++) {
                            Rect R = freeRectangles.get(k);
                            if (R.w >= cubeSize && R.h >= cubeSize) {
                                pickedIndex = k;
                                break;
                            }
                        }
                        if (pickedIndex < 0) {
                            fits2D = false;
                            break;
                        }

                        Rect chosen = freeRectangles.remove(pickedIndex);
                        int w = chosen.w;
                        int h = chosen.h;

                        if (w - cubeSize > 0) {
                            freeRectangles.add(new Rect(w - cubeSize, cubeSize));
                        }
                        if (h - cubeSize > 0) {
                            freeRectangles.add(new Rect(w, h - cubeSize));
                        }
                    }

                    if (fits2D) {
                        canFitInThisBox = true;
                        break;
                    }
                }

                answer.append(canFitInThisBox ? '1' : '0');
            }

            System.out.println(answer);
        }
    }

    static class Rect {

        int w, h;

        Rect(int _w, int _h) {
            w = _w;
            h = _h;
        }
    }
}
