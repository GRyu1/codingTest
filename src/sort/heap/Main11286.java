package sort.heap;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) != Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }
                return o1-o2;
            }
        });

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(bufferedReader.readLine());
            if( input != 0 ){
                priorityQueue.offer(input);
            } else {
                if(priorityQueue.isEmpty()) {
                    bufferedWriter.write("0\n");
                } else {
                    bufferedWriter.write(priorityQueue.poll()+"\n");
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
