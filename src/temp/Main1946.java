package temp;

import java.io.*;
import java.util.StringTokenizer;

public class Main1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            Main1946Structure[] arr = new Main1946Structure[N];
            for (int j=0; j<N ; j++){
                st = new StringTokenizer(bufferedReader.readLine());
                arr[j] = new Main1946Structure(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
            }
            int count=0;
            for(int j=0; j<N; j++){
                boolean flag = true;
                for(int k=0; k<N; k++){
                    if(!compare( arr[j] , arr[k])){
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
            bufferedWriter.write(count+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean compare(Main1946Structure A ,Main1946Structure B) {
        if( A.a > B.a && A.b > B.b){
            return false;
        }
        return true;
    }
}

class Main1946Structure {
    int a;
    int b;

    public Main1946Structure(int a, int b) {
        this.a = a;
        this.b = b;
    }
}