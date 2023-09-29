package setAndMap;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        StringTokenizer stringTokenizer;

        for(int i=0 ; i< N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");
            String method = stringTokenizer.nextToken();
            switch (method){
                case "add":
                    hashSet.add(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "remove":
                    hashSet.remove(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "check":
                    if(hashSet.contains(Integer.parseInt(stringTokenizer.nextToken()))){
                        bufferedWriter.write("1\n");
                    } else {
                        bufferedWriter.write("0\n");
                    }
                    break;
                case "toggle" :
                    int temp;
                    if (hashSet.contains(temp=Integer.parseInt(stringTokenizer.nextToken()))){
                        hashSet.remove(temp);
                    } else {
                        hashSet.add(temp);
                    }
                    break;
                case "all" :
                    for (int j=1; j<=20 ; j++){
                        hashSet.add(j);
                    }
                    break;
                case "empty" :
                    hashSet = new HashSet<>();
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
