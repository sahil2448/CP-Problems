
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int total = n * n;
            int t = total - k;

            if (t > 0 && t < 4) {
                System.out.println("NO");
                continue;
            }

            char[][] mat = new char[n][n];
            boolean[][] used = new boolean[n][n]; 
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = 'U';
                }
            }

            if (t == 0) {
                System.out.println("YES");
                printMat(mat);
                continue;
            }

            int oi = (n >= 3 ? 1 : 0);
            int oj = (n >= 3 ? 1 : 0);

            for (int i = oi; i + 1 < n && t >= 4; i += 2) {
                for (int j = oj; j + 1 < n && t >= 4; j += 2) {
                    mat[i][j] = 'R';
                    mat[i][j + 1] = 'D';
                    mat[i + 1][j + 1] = 'L';
                    mat[i + 1][j] = 'U';
                    used[i][j] = used[i][j + 1] = used[i + 1][j + 1] = used[i + 1][j] = true;
                    t -= 4;
                }
            }

            if (t >= 4) {
                int altOi = (oi == 0 ? 1 : 0);
                int altOj = (oj == 0 ? 1 : 0);
                for (int i = altOi; i + 1 < n && t >= 4; i += 2) {
                    for (int j = altOj; j + 1 < n && t >= 4; j += 2) {
                        if (used[i][j] || used[i][j + 1] || used[i + 1][j] || used[i + 1][j + 1]) {
                            continue;
                        }
                        mat[i][j] = 'R';
                        mat[i][j + 1] = 'D';
                        mat[i + 1][j + 1] = 'L';
                        mat[i + 1][j] = 'U';
                        used[i][j] = used[i][j + 1] = used[i + 1][j + 1] = used[i + 1][j] = true;
                        t -= 4;
                    }
                }
            }

            if (t > 0) {
                int need = t;
                outer:
                for (int i = 0; i < n && need > 0; ++i) {
                    for (int j = 0; j < n && need > 0; ++j) {
                        if (used[i][j]) {
                            continue; 
                        }                     
                        int ni, nj;
                        ni = i - 1;
                        nj = j;
                        if (ni >= 0 && used[ni][nj]) {
                            mat[i][j] = 'U'; 
                            used[i][j] = true;
                            need--;
                            continue;
                        }
                        ni = i + 1;
                        nj = j;
                        if (ni < n && used[ni][nj]) {
                            mat[i][j] = 'D';
                            used[i][j] = true;
                            need--;
                            continue;
                        }
                        ni = i;
                        nj = j - 1;
                        if (nj >= 0 && used[ni][nj]) {
                            mat[i][j] = 'L';
                            used[i][j] = true;
                            need--;
                            continue;
                        }
                        ni = i;
                        nj = j + 1;
                        if (nj < n && used[ni][nj]) {
                            mat[i][j] = 'R';
                            used[i][j] = true;
                            need--;
                            continue;
                        }
                    }
                }

                if (need > 0) {
                    boolean again = true;
                    for (int i = 0; i + 1 < n && need > 0 && again; ++i) {
                        for (int j = 0; j + 1 < n && need > 0; ++j) {
                            if (used[i][j] || used[i][j + 1] || used[i + 1][j] || used[i + 1][j + 1]) {
                                continue;
                            }
                            mat[i][j] = 'R';
                            mat[i][j + 1] = 'D';
                            mat[i + 1][j + 1] = 'L';
                            mat[i + 1][j] = 'U';
                            used[i][j] = used[i][j + 1] = used[i + 1][j + 1] = used[i + 1][j] = true;
                            int added = 4;
                            for (int di = -1; di <= 2 && need > 0; ++di) {
                                for (int dj = -1; dj <= 2 && need > 0; ++dj) {
                                    int x = i + di, y = j + dj;
                                    if (x < 0 || x >= n || y < 0 || y >= n) {
                                        continue;
                                    }
                                    if (used[x][y]) {
                                        continue;
                                    }
                                    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                                    boolean attached = false;
                                    for (int[] d : dirs) {
                                        int nx = x + d[0], ny = y + d[1];
                                        if (nx >= i && nx <= i + 1 && ny >= j && ny <= j + 1 && used[nx][ny]) {
                                            if (nx == x - 1) {
                                                mat[x][y] = 'U';
                                            } else if (nx == x + 1) {
                                                mat[x][y] = 'D';
                                            } else if (ny == y - 1) {
                                                mat[x][y] = 'L';
                                            } else {
                                                mat[x][y] = 'R';
                                            }
                                            used[x][y] = true;
                                            need--;
                                            attached = true;
                                            break;
                                        }
                                    }
                                    if (!attached) {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }

                if (need > 0) {
                    System.out.println("NO");
                    continue;
                }
            }

            System.out.println("YES");
            printMat(mat);
        }
    }

    static void printMat(char[][] mat) {
        for (int i = 0; i < mat.length; ++i) {
            System.out.println(new String(mat[i]));
        }
    }
}
