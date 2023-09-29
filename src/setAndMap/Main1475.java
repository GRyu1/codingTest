package setAndMap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int[] arr = new int[str.length()];
        int[] arrCount =new int[9];
        for (int i=0; i< str.length() ; i++){
            arr[i] = str.charAt(i)-48;
            if(arr[i]!=6 && arr[i]!=9){
                arrCount[arr[i]]++;
            }else {
                arrCount[6]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<arrCount.length ; i++){
            if (i!= 6 && arrCount[i] > max){
                max = arrCount[i];
            } else if ( i ==6 && Math.ceil((float)arrCount[i]/2) > max ){
                max = (int) Math.ceil((float)arrCount[i]/2);
            }
        }

        System.out.println(max);
    }
}
