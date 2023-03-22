package dynamicProgramming;/*package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main13305 {
    static int N;
    static Stack<Integer> road = new Stack<>();
    static Stack<Integer> cost = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine() ,  " ");
        while(st.hasMoreTokens()){
            road.push(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine() ,  " ");
        while(st.hasMoreTokens()){
            cost.push(Integer.parseInt(st.nextToken()));
        }
        cost.pop();

        System.out.println(TotalMinCost());

    }

    private static String TotalMinCost() {
        BigInteger subtotal = BigInteger.ZERO;
        BigInteger costDp = new BigInteger(""+cost.pop());
        BigInteger totalFee = BigInteger.ZERO;

        while(!cost.isEmpty()){
            BigInteger tmp = new BigInteger(""+cost.pop());
            subtotal=subtotal.add(new BigInteger(""+road.pop()));
            if(tmp.compareTo(costDp)==1){
                totalFee=totalFee.add(costDp.multiply(subtotal));
                subtotal=BigInteger.ZERO;
                costDp=tmp;
            }else{
                costDp=tmp;
            }
        }
        subtotal=subtotal.add(new BigInteger(""+road.pop()));
        totalFee=totalFee.add(costDp.multiply(subtotal));

        return totalFee.toString();
    }
}*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N - 1];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }


        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];

        for(int i = 0; i < N - 1; i++) {

            if(cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += (minCost * dist[i]);
        }

        System.out.println(sum);

    }
}

