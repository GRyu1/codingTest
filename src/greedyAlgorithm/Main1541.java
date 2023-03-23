package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1541 {

    public static void main(String[] args) {

        String str = new Scanner(System.in).next();
        String str1 = str.replace("+" , " " );

        StringTokenizer st = new StringTokenizer(str1 , "-");
        StringTokenizer st1;
        ArrayList<Integer> subtotal = new ArrayList<>();

        while(st.hasMoreTokens()) {
            int sum = 0;
            String str2 = st.nextToken();
            st1 = new StringTokenizer(str2 , " ");
            while(st1.hasMoreTokens()){
                sum+=Integer.parseInt(st1.nextToken());
            }
            subtotal.add(sum);
        }
        int a=0;
        int total=subtotal.get(0);

        for(int i=1; i<subtotal.size(); i++){
            total-=subtotal.get(i);
        }
        System.out.println(total);
    }
}
