package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1012 {
    static boolean[][] canVisit;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer ;
        int testCase = Integer.parseInt(bufferedReader.readLine());
        for(int i=0; i<testCase ; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            canVisit = new boolean[N+2][M+2];

            int K = Integer.parseInt(stringTokenizer.nextToken());
            for(int j=0; j < K; j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                canVisit[y+1][x+1] = true;
            }
            int count = 0;
            for(int j = 1 ; j<=N; j++){
                for(int k=1; k<=M; k++){
                    if(canVisit[j][k]){
                        bfs(j , k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int y ,int x) {
        Queue<Point> q = new LinkedList<>();
        canVisit[y][x] = false;
        Point p = new Point(x,y);
        q.offer(p);

        while(q.size()!=0){
            p = q.poll();
            if(canVisit[p.y+1][p.x]){
                q.offer(new Point(p.x,p.y+1));
                canVisit[p.y+1][p.x]=false;
            }
            if(canVisit[p.y][p.x+1]){
                q.offer(new Point(p.x+1,p.y));
                canVisit[p.y][p.x+1]=false;
            }
            if(canVisit[p.y-1][p.x]){
                q.offer(new Point(p.x,p.y-1));
                canVisit[p.y-1][p.x]=false;
            }
            if(canVisit[p.y][p.x-1]){
                q.offer(new Point(p.x-1,p.y));
                canVisit[p.y][p.x-1]=false;
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