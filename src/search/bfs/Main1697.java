package search.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine() ," ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        if(N<K){
            Queue<Integer> queue = new LinkedList<>();
            Integer[] visited = new Integer[K+2];
            queue.offer(N);
            visited[N] = 0;
            while(visited[K]==null){
                int node = queue.poll();
                if(node+1 <= K+1 && visited[node+1]==null){
                    queue.offer(node+1);
                    visited[node+1]=visited[node]+1;
                }
                if(node-1>=0 && visited[node-1]==null){
                    queue.offer(node-1);
                    visited[node-1]=visited[node]+1;
                }
                if(node*2 <= K+1 && visited[node*2]==null){
                    queue.offer(node*2);
                    visited[node*2]=visited[node]+1;
                }
            }
            System.out.println(visited[K]);
        } else {
            System.out.println(N-K);
        }
    }
}
