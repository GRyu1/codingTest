package recrusion;

import java.util.Scanner;

public class Main1074 {
    private static int N, r, c, start, answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();

        sol1074();
        System.out.println(answer);
    }

    public static void sol1074() {
        if (N == 1) {
            if (r == 0 && c == 0) {
                answer = start;
            } else if (r == 1 && c == 0) {
                answer = start + 1;
            } else if (r == 0 && c == 1) {
                answer = start + 2;
            } else {
                answer = start + 3;
            }
            return;
        }
        boundaryChecker();
        sol1074();
    }

    public static void boundaryChecker() {
        N--;
        int boundary = (int) Math.pow(2, N);
        int section;
        if ((r >= 0 && boundary > r) && (c >= 0 && boundary > c)) {

        } else if ((r < boundary * 2 && boundary <= r) && (c >= 0 && boundary > c)) {
            r -= boundary;
            section = 2;
            start += section * boundary * boundary;
        } else if ((r >= 0 && boundary > r) && (c < boundary * 2 && boundary <= c)) {
            c -= boundary;
            section = 1;
            start += section * boundary * boundary;
        } else {
            c -= boundary;
            r -= boundary;
            section = 3;
            start += section * boundary * boundary;
        }
    }
}
