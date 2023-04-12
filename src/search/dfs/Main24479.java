package search.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main24479 {
    static BufferedReader br;
    static BufferedWriter bw;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> answer=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited=new boolean[N+1];

        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i< graph.size();i++){
            graph.get(i).sort(Comparator.naturalOrder());
        }

        dfs(start);
        for(int i=0; i<N; i++){
            if(i< answer.size())
                System.out.println(answer.get(i));
            else System.out.println(0);
        }


    }

    private static void dfs(int start) throws IOException {
        visited[start]=true;
        answer.add(start);
        for( int idx : graph.get(start)){
            if(!visited[idx])
            dfs(idx);
        }

    }
}
