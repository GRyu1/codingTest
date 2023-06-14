package temp;

import java.io.*;
import java.util.StringTokenizer;

public class Main16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");

        int H = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int Y = Integer.parseInt(stringTokenizer.nextToken());

        Integer[][] arrSum = new Integer[H+X][W+Y];
        Integer[][] arr = new Integer[H][W];

        for (int i=0; i< H+X; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");
            int j=0;
            while(stringTokenizer.hasMoreTokens()){
                arrSum[i][j++] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=H ; i<H+X ; i++) {
            for(int j=Y ; j<W+Y ; j++){
                arr[i-X][j-Y] = arrSum[i][j];
            }
        }
        for(int j=W ; j<W+Y ; j++){
            for(int i=X ; i<H+X ; i++) {
                arr[i-X][j-Y] = arrSum[i][j];
            }
        }
        for(int i=H-1; i>=0 ; i--){
            for(int j=W-1; j>=0; j--){
                if(arr[i][j]==null){
                    arr[i][j] = arrSum[i+X][j+Y]-arr[i+X][j+Y];
                }
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                bufferedWriter.write(arr[i][j]+" ");
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
