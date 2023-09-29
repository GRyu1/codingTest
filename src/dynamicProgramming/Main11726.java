package dynamicProgramming;

import java.io.*;

public class Main11726 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bufferedReader.readLine());
        int[] dp = N<3 ? new int[3] : new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3 ; i<=N; i++){
            dp[i] = (dp[i-1]+ dp[i-2])%10007;
        }
        bufferedWriter.write(dp[N]+"");
        bufferedWriter.flush();
        bufferedReader.close();
    }

}
