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
            }else {
                heapSort();
                bufferedWriter.write(HeapPrinter()+"\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }
    private static void heapSort() {
        if (Heap.size()==1 || Heap.size()==0) return;
        int parentIdx = (Heap.size()-2)/2;
        for(int i=parentIdx; i>=parentIdx; i--){
            heapify(i);
        }
    }

    private static void heapify(int parentIdx) {
        int parent = parentIdx;
        int leftChild = parent*2+1;
        int rightChild = leftChild+1;

        if(leftChild < Heap.size() && Heap.get(parent) > Heap.get(leftChild))
            parent = leftChild;
        if(rightChild < Heap.size() &&Heap.get(parent) > Heap.get(rightChild))
            parent = rightChild;

        if(parent!=parentIdx){
            swap(parent , parentIdx);
            heapify(parent);
        }
    }

    private static void swap(int parent , int child){
        int temp = Heap.get(parent);
        Heap.set(parent, Heap.get(child));
        Heap.set(child, temp);
    }
    private static int HeapPrinter() {
        if(Heap.size() == 0) return 0;
        int result = Heap.get(0);
        Heap.remove(0);
        if(Heap.size()>=2 && Heap.get(0)>Heap.get(1)) swap(0,1);
        return result;
    }
}