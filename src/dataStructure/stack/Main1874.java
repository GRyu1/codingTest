package dataStructure.stack;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N;i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for(int i=0; i<arr[0] ; i++){
            stringBuilder.append("+\n");
        }

        stringBuilder.append("-\n");

        int meme=0;
        int Nidx=Arrays.binarySearch(arr, N);

        for(int i=1; i<=Nidx; i++){
            if(arr[i-1]-arr[i]==1){
                if(meme<arr[i-1]) meme=arr[i-1];
                stringBuilder.append("-\n");
            }else if(arr[i-1]<arr[i]){
                for(int j=0; j<arr[i]-meme; j++){
                    stringBuilder.append("+\n");
                }
                stringBuilder.append("-\n");
                meme=arr[i];
            }else {
                System.out.println("NO");
                System.exit(0);
            }
        }

        for(int i=Nidx ; i<N-1 ; i++){
            if(arr[i]<arr[i+1]) {
                System.out.println("NO");
                System.exit(0);
            }else{
                stringBuilder.append("-\n");
            }
        }
        System.out.println(stringBuilder);
    }



}
