package search.bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11724 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N,M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N+1];

        for(int i=0 ;i<=N ; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        int c;
        int count=0;
        while( (c=clear()) != -1 ){
            count++;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(c);
            visited[c] = true;

            while (!queue.isEmpty()){
                int idx = queue.poll();
                for(int node : graph.get(idx)){
                    if(!visited[node]){
                        visited[node]=true;
                        queue.offer(node);
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int clear() {
        for(int i=1; i<visited.length ; i++ ){
            if(!visited[i]) return i;
        }
        return -1;
    }
}
