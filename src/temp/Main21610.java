package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21610 {
    static int[][] arr;
    static int N;
    static int M;
    static boolean[][] isThereCloud;
     // 1←, 2↖, 3↑, 4↗, 5→, 6↘, 7↓, 8↙
     static boolean[][] movedCloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+2][N+2];
        isThereCloud = new boolean[N+1][N+1];
        movedCloud = new boolean[N+1][N+1];

        isThereCloud[N][1]=true;
        isThereCloud[N][2]=true;
        isThereCloud[N-1][1]=true;
        isThereCloud[N-1][2]=true;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            moveCloud(d , s); // 1.구름 이동 2.비내리고
            copyWater(); // 물복사 구름사라짐
            makeCloud(); //
        }

        int sum=0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sum+=arr[i][j];
            }
        }
        System.out.println(sum);

    }

    private static void makeCloud() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!movedCloud[i][j]&&arr[i][j]>=2){
                    arr[i][j]-=2;
                    isThereCloud[i][j]=true;
                }
            }
        }
        for(int i=1 ; i<=N; i++){
            for(int j =1 ; j<=N; j++){
                movedCloud[i][j]=false;
            }
        }
    }

    private static void copyWater() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(movedCloud[i][j]){
                    int count = 0 ;
                    if(arr[i + 1][j + 1]!=0) count++;
                    if(arr[i - 1][j + 1]!=0) count++;
                    if(arr[i + 1][j - 1]!=0) count++;
                    if(arr[i - 1][j - 1]!=0) count++;
                    arr[i][j]+=count;
                }
            }
        }
    }

    private static void moveCloud(int d, int s) {
        for(int i=1;i<=N; i++){
            for(int j=1;j<=N; j++){
                if(isThereCloud[i][j]) {
                    int idxX = spotXManipulator(j, d, s);
                    int idxY = spotYManipulator(i, d, s);

                    movedCloud[idxY][idxX] = true;
                    arr[idxY][idxX]++;
                    isThereCloud[i][j]=false;
                }
            }
        }
    }

    private static int spotYManipulator(int i, int d, int s) {
        switch (d) {
            case 2: case 3: case 4:
                if (i - s < 1) return (i - s) % N + N;
                else return i - s;
            case 6: case 7: case 8:
                if (i + s > 1) return (i + s) % N == 0 ? N : ( i + s ) % N;
                else return i + s;
            default:
                return i;
        }
    }

    private static int spotXManipulator(int j, int d, int s) {
        switch (d) {
            case 1: case 2: case 8:
                if (j - s < 1) return (j - s) % N + N;
                else return j - s;
            case 6: case 5: case 4:
                if (j + s > 1) return (j + s) % N == 0 ? N : ( j + s ) % N;
                else return j + s;
            default:
                return j;
        }
    }
}
