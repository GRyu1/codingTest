package sort.heap;

import java.io.*;
import java.util.ArrayList;

public class Main1927 {
    static ArrayList<Integer> Heap = new ArrayList<>();
    static int N,x;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(bufferedReader.readLine());
            if(temp != 0){
                Heap.add(temp);
                heapify();
            }else {
                bufferedWriter.write(HeapPrinter()+"");
            }
        }
    }

    private static void heapify() {

    }
    private static int HeapPrinter() {
        return Heap.size() == 0 ? 0 : Heap.get(0);
    }
}
