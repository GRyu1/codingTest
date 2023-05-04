package dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
input
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1

output
1
2
5

* */
public class Main1966 {
    static Queue<PrintObject> q;
    static ArrayList<Integer> al;
    static ArrayList<Integer> sortedOrder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            q = new LinkedList<>();
            al = new ArrayList<>();
            sortedOrder = new ArrayList<>();

            int M=0;
            int targetIdx=0;
            st=new StringTokenizer(br.readLine() , " ");
            while(st.hasMoreTokens()){
                M=Integer.parseInt(st.nextToken());
                targetIdx=Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int weight = Integer.parseInt(st.nextToken());
                al.add(weight);
                q.add(new PrintObject(j,weight));
            }
            al.sort(Comparator.reverseOrder());
            orderSortAndSearch(q , targetIdx);
            System.out.println(sortedOrder.size());
        }

    }

    private static void orderSortAndSearch (Queue<PrintObject> q , int targetIdx) {
        int temp=0;
        while(true){
            PrintObject printObject=q.poll();
            if(printObject.weight == al.get(temp)) {
                sortedOrder.add(printObject.idx);
                temp++;
                if(printObject.idx==targetIdx) return;
            }
            else{
                q.add(printObject);
            }
        }

    }

}

class PrintObject{
    int idx;
    int weight;

    public PrintObject(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

}