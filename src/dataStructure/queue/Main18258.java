package dataStructure.queue;

import java.io.*;
import java.util.*;

public class Main18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> deque = new ArrayDeque<>();
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;

        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine() , " ");
            String str;
            switch (stringTokenizer.nextToken()){
                case "push" : deque.offer(stringTokenizer.nextToken());
                    break;
                case "pop" :
                    str = deque.pollFirst();
                    bufferedWriter.write(str==null? -1+"\n" : str+"\n");

                    break;
                case "size" :
                    bufferedWriter.write(deque.size()+"\n");
                    break;
                case "empty" :
                    bufferedWriter.write(deque.isEmpty() ? 1+"\n" : 0+"\n");
                    break;
                case "front" :
                    str = deque.peekFirst();
                    bufferedWriter.write(str==null? -1+"\n" : str+"\n");
                    break;
                case "back" :
                    str = deque.peekLast();
                    bufferedWriter.write(str==null? -1+"\n" : str+"\n");
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
