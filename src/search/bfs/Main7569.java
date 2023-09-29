package search.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {
    static int N, H,M;
    static boolean visited[][][];
    static int graph[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] dx = {0,0,1,-1,0,0};
        int[] dy = {1,-1,0,0,0,0};
        int[] dz = {0,0,0,0,1,-1};

        Queue<Node> queue = new LinkedList<>();

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                int m = 0;
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                while (stringTokenizer.hasMoreTokens()) {
                    int temp = Integer.parseInt(stringTokenizer.nextToken());
                    graph[h][n][m] = temp;
                    if (temp == 1) {
                        queue.offer(new Node(h, n, m , 0));
                        visited[h][n][m] = true;
                    } else if ( temp == -1) {
                        visited[h][n][m] = true;
                    }
                    m++;
                }
            }
        }

        int depth = 0;

        while(!queue.isEmpty()){
            while(!queue.isEmpty()) {
                Node start = queue.peek();
                if(start.depth != depth -1) break;
                queue.remove(start);
                for (int i = 0; i < 6; i++) {
                    int newIdxH = start.h + dz[i];
                    int newIdxN = start.n + dx[i];
                    int newIdxM = start.m + dy[i];
                    if (!( (0 <= newIdxH && newIdxH < H) && (0 <= newIdxN && newIdxN < N) && (0 <= newIdxM && newIdxM < M) )) continue;
                    if (!visited[newIdxH][newIdxN][newIdxM] && graph[newIdxH][newIdxN][newIdxM] == 0) {
                        visited[newIdxH][newIdxN][newIdxM] = true;
                        queue.offer(new Node(newIdxH, newIdxN, newIdxM , depth));
                    } else if (!visited[newIdxH][newIdxN][newIdxM] && graph[newIdxH][newIdxN][newIdxM] == -1) {
                        visited[newIdxH][newIdxN][newIdxM] = true;
                    }
                }
            }
            if(Checker()){
                bufferedWriter.write(depth+"");
                break;
            }
            depth++;
        }
        if (!Checker()){
            bufferedWriter.write("-1");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
    private static boolean Checker() {
        for(int h=0; h<H; h++){
            for(int n=0; n<N ; n++){
                for(int m=0; m<M ; m++){
                    if(!visited[h][n][m])
                        return false;
                }
            }
        }
        return true;
    }
}
class Node {
    int h;
    int n;
    int m;
    int depth;

    public Node(int h, int n, int m, int depth
    ) {
        this.h = h;
        this.n = n;
        this.m = m;
        this.depth = depth;
    }
}