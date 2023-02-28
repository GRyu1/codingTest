package backtracking;

import java.util.Scanner;

public class Main12095Ex {
    static int[][] a;
    static boolean[][] c, c2, c3;
    static int n = 9;
    static int cnt = 0;

    static int square(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }

    static boolean go(int z) {
        cnt += 1;
        if (cnt >= 10000000) {
            return true;
        }
        if (z == 81) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        int x = z / n;
        int y = z % n;
        if (a[x][y] != 0) {
            return go(z + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (c[x][i] == false && c2[y][i] == false && c3[square(x, y)][i] == false) {
                    c[x][i] = c2[y][i] = c3[square(x, y)][i] = true;
                    a[x][y] = i;
                    if (go(z + 1)) {
                        return true;
                    }
                    a[x][y] = 0;
                    c[x][i] = c2[y][i] = c3[square(x, y)][i] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new int[n][n];
        c = new boolean[n][n];
        c2 = new boolean[n][n];
        c3 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] != 0) {
                    c[i][a[i][j]] = true;
                    c2[j][a[i][j]] = true;
                    c3[square(i, j)][a[i][j]] = true;
                }
            }
        }
        go(0);
    }
}
