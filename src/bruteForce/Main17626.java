package bruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main17626 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] dp = new int[n+1];
        dp[1]=1;

        for(int i=2 ; i<=n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j*j<=i ; j++) {
                if (min > dp[i - j * j]) {
                    min = dp[i - j * j];
                }
            }
            dp[i] = min +1;
        }
        System.out.println(dp[n]);
    }
}
