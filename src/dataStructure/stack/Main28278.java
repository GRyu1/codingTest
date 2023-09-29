package dataStructure.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        String command;
        for (int i=0; i<N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            switch (stringTokenizer.nextToken()){
                case "1":
                    stack.push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "2":
                    if(stack.isEmpty()) {
                        bufferedWriter.write("-1\n");
                    } else {
                        bufferedWriter.write(stack.pop() + "\n");
                    }
                    break;
                case "3":
                    bufferedWriter.write(stack.size()+"\n");
                    break;
                case "4":
                    bufferedWriter.write(stack.isEmpty()? "1\n":"0\n");
                    break;
                case "5":
                    if(stack.isEmpty()) {
                        bufferedWriter.write("-1\n");
                    } else {
                        bufferedWriter.write(stack.peek() + "\n");
                    }
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}