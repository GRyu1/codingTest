package dataStructure.stack;//package dataStructure.stack;
//
//import java.io.*;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class Main1874 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        StringBuilder stringBuilder = new StringBuilder();
//        Stack<Integer> stack = new Stack<>();
//
//        int N = Integer.parseInt(bufferedReader.readLine());
//        int[] arr = new int[N];
//
//        for(int i=0; i<N;i++){
//            arr[i] = Integer.parseInt(bufferedReader.readLine());
//        }
//
//        for(int i=0; i<arr[0] ; i++){
//            stringBuilder.append("+\n");
//        }
//
//        stringBuilder.append("-\n");
//
//        int meme=0;
//        int Nidx=Arrays.binarySearch(arr, N);
//
//        for(int i=1; i<=Nidx; i++){
//            if(arr[i-1]-arr[i]==1){
//                if(meme<arr[i-1]) meme=arr[i-1];
//                stringBuilder.append("-\n");
//            }else if(arr[i-1]<arr[i]){
//                for(int j=0; j<arr[i]-meme; j++){
//                    stringBuilder.append("+\n");
//                }
//                stringBuilder.append("-\n");
//                meme=arr[i];
//            }else {
//                System.out.println("NO");
//                System.exit(0);
//            }
//        }
//
//        for(int i=Nidx ; i<N-1 ; i++){
//            if(arr[i]<arr[i+1]) {
//                System.out.println("NO");
//                System.exit(0);
//            }else{
//                stringBuilder.append("-\n");
//            }
//        }
//        System.out.println(stringBuilder);
//    }
//
//
//
//}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();   // 출력할 결과물 저장

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        int start = 0;

        // N 번 반복
        while(N -- > 0) {
            int value = Integer.parseInt(br.readLine());
            if(value > start) {
                // start + 1부터 입력받은 value 까지 push를 한다.
                for(int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');   // + 를 저장한다.
                }
                start = value;    // 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            }

            else if(stack.peek() != value) {
                System.out.println("NO");
                return;      // 또는 System.exit(0); 으로 대체해도 됨.
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}