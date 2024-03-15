package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Main11049 {
    static int N;
    static int[][] dp;
    static int[][] processions;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bufferedReader.readLine());
        dp = new int[N+1][N+1];
        processions = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            processions[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            processions[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i=1 ; i< N; i++) {
            dp[i][i+1] = processions[i][0] * processions[i+1][0] * processions[i+1][1];
        }

        for (int gap = 2 ; gap < N ; gap++) {
            for (int start = 1 ; start + gap <= N ; start++) {
                int end = start + gap;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start ; mid < end; mid++) {
                    dp[start][end] = Math.min(dp[start][end] , dp[start][mid] + dp[mid+1][end] + processions[start][0] * processions[mid][1] * processions[end][1]);
                }
            }
        }


        bufferedWriter.write(String.valueOf(dp[1][N]));
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
