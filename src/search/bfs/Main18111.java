package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {
    static int N,M,B,bag;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());


        int[][] arr = new int[N][M];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i][j]=Integer.parseInt(stringTokenizer.nextToken());
                max = Math.max(max , arr[i][j]);
                min = Math.min(min , arr[i][j]);
            }
        }
        int[] meme = new int[max-min+1];
        int hight = min;

        int timemin=Integer.MAX_VALUE;
        int hightidx = 0;
        for(int i=0; i<meme.length ; i++){
            bag = B;
            meme[i] = timeChecker(arr , hight);
            if(timemin>=meme[i]){
                timemin = meme[i];
                hightidx = i+min;
            }
            hight++;
        }
        System.out.println(timemin+" "+hightidx);


    }

    private static int timeChecker(int[][] arr, int hight) {
        int time=0;
        int blocks=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                time+= arr[i][j]-hight > 0 ? (arr[i][j]-hight)*2 : (arr[i][j]-hight) * (-1) ;
                blocks-=arr[i][j]-hight;
            }
        }
        if(blocks>bag) return Integer.MAX_VALUE;
        return time;
    }
}