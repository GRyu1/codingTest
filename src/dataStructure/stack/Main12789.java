package dataStructure.stack;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main12789 {
    static Queue<Integer> line = new LinkedList<>();
    static Stack<Integer> readyLine = new Stack<>();
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;
    public static void main(String[] args) throws IOException {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()){
            line.offer(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int number = 1;
        while(true){
            if(line.isEmpty()) {
                bufferedWriter.write("Nice");
                break;
            }

            if(line.peek() == number ){
                line.poll();
                number++;
            } else if (!readyLine.isEmpty() && number == readyLine.peek()) {
                readyLine.pop();
                number++;
            } else {
                if(!readyLine.empty() && readyLine.peek() < line.peek()) {
                    bufferedWriter.write("Sad");
                    break;
                }
                readyLine.push(line.poll());
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
