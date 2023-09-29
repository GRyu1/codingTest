package search.bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
    static int N, M ;
    static int arr[][];
    static Integer answer[][];
    static boolean visited[][];
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");

        ArrayList<Point> arrayList = new ArrayList<>();


        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N][M];
        answer = new Integer[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
            int j=0;
            while(stringTokenizer.hasMoreTokens()){
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                if(temp == 1){
                    Point point = new Point(i,j);
                    q.offer(point);
                    visited[point.i][point.j] = true;
                    answer[point.i][point.j] = 0;
                }
                arr[i][j++] = temp;
            }
        }

        while(!q.isEmpty()){
            Point node = q.poll();

            if(node.i-1>=0 && !visited[node.i-1][node.j] && arr[node.i-1][node.j]==0 ){
                q.offer(new Point(node.i-1 , node.j));
                visited[node.i-1][node.j] = true;
                answer[node.i-1][node.j] = answer[node.i][node.j]+1;
            }
            if(node.j-1>=0 && !visited[node.i][node.j-1] && arr[node.i][node.j-1]==0){
                q.offer(new Point(node.i , node.j-1));
                visited[node.i][node.j-1] = true;
                answer[node.i][node.j-1] = answer[node.i][node.j]+1;
            }
            if(node.j+1<M && !visited[node.i][node.j+1] && arr[node.i][node.j+1]==0){
                q.offer(new Point(node.i , node.j+1));
                visited[node.i][node.j+1] = true;
                answer[node.i][node.j+1] = answer[node.i][node.j]+1;
            }
            if(node.i+1<N && !visited[node.i+1][node.j] && arr[node.i+1][node.j]==0 ){
                q.offer(new Point(node.i+1 , node.j));
                visited[node.i+1][node.j] = true;
                answer[node.i+1][node.j] = answer[node.i][node.j]+1;
            }
        }

        int max=-1;
        for(int i=0 ; i<N ; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==-1) answer[i][j]=-1;
                if(answer[i][j]==null){
                    bufferedWriter.write("-1");
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    bufferedReader.close();
                    System.exit(0);
                }
                max=Math.max(max,answer[i][j]);
            }
        }
        bufferedWriter.write(max+"");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class Point {
    int i;
    int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}