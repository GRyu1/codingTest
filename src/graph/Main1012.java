package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Main1012 {
    static int count=0;
    static boolean[][] visited;
    static int[][] map;

    static int T,N,M,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        T = Integer.parseInt(st.nextToken());




        for(int t=0; t<T; t++){

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i=0; i<K ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
                visited[a][b] = true;
            }
            for(int i=0;i<N;i++){
                for(int j=0; j<M; j++){
                    if(visited[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
            count=0;
        }

    }

    private static void bfs(int i, int j) {

        Spot start =new Spot(i,j);
        Queue<Spot> q = new LinkedBlockingDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            Spot node = q.poll();
            visited[node.i][node.j]=false;
            Spot tmp;

            if(node.i>1 && visited[node.i-1][node.j]){
                tmp = new Spot(i-1,j);
                q.offer(tmp);
                visited[node.i-1][node.j]=false;
            }
            if(node.j>1 && visited[node.i][node.j-1]){
                tmp = new Spot(i,j-1);
                q.offer(tmp);
                visited[node.i][node.j-1]=false;
            }
            if(node.i<N-1 && visited[node.i+1][node.j]){
                tmp = new Spot(i+1,j);
                q.offer(tmp);
                visited[node.i+1][node.j]=false;
            }
            if(node.j<N-1 && visited[node.i][node.j+1]){
                tmp = new Spot(i,j+1);
                q.offer(tmp);
                visited[node.i][node.j+1]=false;
            }
        }
    }
}

class Spot{
    int i;
    int j;

    public Spot(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
