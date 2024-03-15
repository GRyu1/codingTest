package dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Main9465 {
    static int N;
    static int r;
    static int[][] sticker;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            r = Integer.parseInt(bufferedReader.readLine());
            sticker = new int[2][r];
            dp = new int[2][r+1];
            for (int j = 0; j < 2; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                for (int k = 0; k < r; k++) {
                    sticker[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            dp[0][0]=0;
            dp[1][0]=0;
            dp[0][1]=sticker[0][0];
            dp[1][1]=sticker[1][0];

            for (int j = 2; j <= r ; j++) {
                dp[0][j] = Math.max(dp[1][j-1],dp[1][j-2])+sticker[0][j-1];
                dp[1][j] = Math.max(dp[0][j-1],dp[0][j-2])+sticker[1][j-1];
            }
            if(i!=0) bufferedWriter.write("\n");
            bufferedWriter.write(Math.max(dp[0][r],dp[1][r])+"");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
