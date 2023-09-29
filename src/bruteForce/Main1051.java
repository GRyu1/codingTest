package bruteForce;

import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main1051 {
    static int N,M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        int min = Math.min(N, M);
        int answer = 1;
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String readLine = bufferedReader.readLine();
            for(int j=0; j < M ; j++){
                arr[i][j] = readLine.charAt(j)-'0';
            }
        }

        exit:
        for (int i = min; i > 1; i--) {
            for (int j = 0; j <= N - i; j++) {
                for (int k = 0; k <= M - i; k++) {
                    if (arr[j][k] == arr[j + i-1][k + i-1] && arr[j + i-1][k + i-1] == arr[j][k + i-1] && arr[j + i-1][k + i-1] == arr[j + i-1][k]) {
                        answer = i;
                        break exit;
                    }
                }
            }
        }
        bufferedWriter.write(String.valueOf(answer*answer));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
