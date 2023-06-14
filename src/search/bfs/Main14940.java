package search.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main14940 {
    static int N,M,targetI,targetJ;
    static boolean visited[][];
    static int graph[][], answer[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        answer = new int[N][M];
        graph = new int[N][M];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int j=0;
            while (stringTokenizer.hasMoreTokens()){
                graph[i][j]=Integer.parseInt(stringTokenizer.nextToken());
                if(graph[i][j]==2){
                    targetI = i;
                    targetJ = j;
                }
                j++;
            }
        }
        bfs(targetI, targetJ);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bufferedWriter.write(answer[i][j]==0? graph[i][j]==0? "0 " : graph[i][j]==2? "0 " : "-1 " : (answer[i][j]+" "));
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void bfs(int targetI , int targetJ) {
        int count = 0;
        LinkedList<Point> queue = new LinkedList<>();
        visited[targetI][targetJ]=true;
        answer[targetI][targetJ]=count;
        queue.offer(new Point(targetI, targetJ));

        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.x < N-1 && !visited[point.x+1][point.y] && graph[point.x+1][point.y]==1){
                queue.offer(new Point(point.x+1, point.y));
                answer[point.x+1][point.y] = answer[point.x][point.y] + 1;
                visited[point.x+1][point.y] = true;
            }
            if(point.y < M-1 && !visited[point.x][point.y+1] && graph[point.x][point.y+1]==1){
                queue.offer(new Point(point.x, point.y+1));
                answer[point.x][point.y+1] = answer[point.x][point.y] + 1;
                visited[point.x][point.y+1] = true;
            }
            if(0 < point.x && !visited[point.x-1][point.y] && graph[point.x-1][point.y]==1){
                queue.offer(new Point(point.x-1, point.y));
                answer[point.x-1][point.y] = answer[point.x][point.y] + 1;
                visited[point.x-1][point.y] = true;
            }
            if(0 < point.y && !visited[point.x][point.y-1] && graph[point.x][point.y-1]==1){
                queue.offer(new Point(point.x, point.y-1));
                answer[point.x][point.y-1] = answer[point.x][point.y] + 1;
                visited[point.x][point.y-1] = true;
            }
        }
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
