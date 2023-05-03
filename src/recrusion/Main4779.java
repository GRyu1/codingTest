package recrusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main4779 {
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        String str;
        while((str=bufferedReader.readLine()) != null){
            int N = Integer.parseInt(str);
            sb = new StringBuilder();
            int length = 1;
            for(int i=0; i<N; i++){
                length*=3;
            }
            arr=new char[length];
            for(int i=0; i<length; i++){
                arr[i] = '-';
            }
            cutter(0 ,length);
            for(char c : arr){
                sb.append(c);
            }
            System.out.println(sb);
        }

    }

    private static void cutter(int start, int length) {
        if(length/3==0) return ;
        int cutIdx = start+length/3;
        for(int i=0; i<length/3 ; i++){
            arr[cutIdx+i]=' ';
        }
        cutter(start+2*length/3, length/3);
        cutter(start,length/3);
    }
}
