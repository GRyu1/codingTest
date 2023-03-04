package heap;

import java.io.*;

public class HeapSort {

    static final int N = 10;

    public static void main(String[] args) throws IOException {
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[100000000];
        for (int i = 0; i <arr.length; i++) {
            arr[i] = (int)(Math.random()*100000000+1);
        }
        
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        arr=heapSort(arr);
        for(int i=0; i<arr.length;i++) {
        	bw.write(arr[i]+"\n");
        }
        
        long millisAfter = System.currentTimeMillis();
        System.out.println(millisAfter);
        System.out.println(millisAfter-millis);
    }

    private static int[] heapSort(int[] arr) {
        int n = arr.length; // ==maxParentIdx

        // maxHeap을 구성
        // n/2-1 : 부모노드의 인덱스를 기준으로 왼쪽(i*2+1) 오른쪽(i*2+2)
        // 즉 자식노드를 갖는 노트의 최대 개수부터
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i); // 일반 배열을 힙으로 구성
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0); // 요소를 제거한 뒤 다시 최대힙을 구성
        }
        return arr;
    }

    private static void heapify(int[] arr, int n, int i) {
        int parent = i;
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;

        // 왼쪽 자식노드 "leftChild < n"=="배열의 마지막 인덱스보다 leftChild인덱스가 앞에있다"
        if (leftChild < n && arr[parent] < arr[leftChild])
            parent = leftChild;
        // 오른쪽 자식노드 "rightChild < n"=="배열의 마지막 인덱스보다 rightChild인덱스가 앞에있다"
        if (rightChild < n && arr[parent] < arr[rightChild])
            parent = rightChild;

        // 부모노드 < 자식노드
        if (i != parent) {
            swap(arr, parent, i);
            heapify(arr, n, parent);
        }
    }

    private static void swap(int[] arr, int parent, int child) {
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }
}