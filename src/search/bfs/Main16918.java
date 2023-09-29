package search.bfs;

import java.io.*;
import java.util.*;

public class Main16918 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Boom> queue = new LinkedList<>();
        int[] dx = {0,1,-1,0,0};
        int[] dy = {0,0,0,1,-1};

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        Boom[][] arr = new Boom[R][C];

        for(int i=0; i<R ; i++){
            String str = bufferedReader.readLine();
            for(int j = 0 ; j<C ; j++){
                if(str.charAt(j) == 'O'){
                    Boom boom = new Boom(i,j);
                    arr[i][j] = boom ;
                }
            }
        }
        int time=0;
        while( time <= N ) {
            if(time > 1) {
                if (time % 2 == 0) {
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (arr[i][j] == null) {
                                arr[i][j] = new Boom(i, j);
                            }
                        }
                    }
                }

                boolean[][] visited = new boolean[R][C];

                while (!queue.isEmpty()) {
                    Boom node = queue.poll();
                    for (int i = 0; i < 5; i++) {
                        int newIdxI = node.i + dx[i];
                        int newIdxJ = node.j + dy[i];
                        if (!(newIdxI >= 0 && newIdxJ >= 0 && newIdxI < R && newIdxJ < C)) continue;
                        if (!visited[newIdxI][newIdxJ]) {
                            visited[newIdxI][newIdxJ] = true;
                            arr[newIdxI][newIdxJ] = null;
                        }
                    }
                }
            }
            for(int i=0 ; i<R ; i++) {
                for(int j = 0 ; j<C; j++){
                    if(arr[i][j]!=null) {
                        arr[i][j].time--;
                        if( arr[i][j].time==0 ) queue.add(arr[i][j]);
                    }
                }
            }
            time++;
        }
        for(int i=0; i<R ; i++){
            for(int j=0; j<C ;j++){
                bufferedWriter.write( arr[i][j] == null ? "." : "O");
            }
            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();

    }
}

class Boom {
    int i;
    int j;
    int time;

    public Boom(int i, int j) {
        this.i = i;
        this.j = j;
        this.time = 3;
    }
}
