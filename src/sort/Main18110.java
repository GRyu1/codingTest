package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        int sum = 0;
        if(N!=0) {
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(bufferedReader.readLine());
                sum += arr[i];
            }
            Arrays.sort(arr);
            for (int i = 0; i < Math.round(N * 0.15); i++) {
                sum-=arr[i];
                sum-=arr[N-1-i];
            }
            System.out.println((int)Math.ceil((float)sum/(N-2*Math.round(N*0.15))));
        }else {
            System.out.println(0);
        }
    }
}
