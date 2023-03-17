package greedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br. readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];

        for(int i=0; i<N; i++){
            coin[i]=Integer.parseInt(br.readLine());
        }
        int count = 0 ;
        int i = N-1;
        while(true){
            if(coin[i]<=M){
                count+=M/coin[i];
                M%=coin[i];
            }
            i--;
            if(M==0) break;
        }

        System.out.println(count);
    }
}
