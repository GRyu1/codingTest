package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;
    static int M;
    static int start;
    static StringBuilder sb;
    static boolean[] checker;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        checker = new boolean[N+1];
        sb = new StringBuilder();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            graph.get(X).add(Y);
            graph.get(Y).add(X);
        }
        dfs(start);
        System.out.println(sb);
        bfs(start);
    }

    private static void dfs(int start) {
        checker[start]=true;
        sb.append(start);
        for(int idx : graph.get(start)){
            if(!checker[idx]) dfs(idx);
        }
    }

    private static void bfs(int start) {
        checker = new boolean[N+1];
        sb = new StringBuilder();
        System.out.println(sb);
    }

}