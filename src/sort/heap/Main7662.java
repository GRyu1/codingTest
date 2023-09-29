package sort.heap;

import java.io.*;
import java.util.*;

public class Main7662 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        HashMap<Integer, Integer> hashMap;


        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i =0 ; i<N; i++) {
            int M = Integer.parseInt(bufferedReader.readLine());
            hashMap = new HashMap<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < M; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                String cal = stringTokenizer.nextToken();
                int val = Integer.parseInt(stringTokenizer.nextToken());
                if (cal.equals("I")) {
                    hashMap.put(val , hashMap.getOrDefault(val,0)+1);
                    maxHeap.add(val);
                    minHeap.add(val);
                } else {
                    if (hashMap.isEmpty()) {
                        continue;
                    }
                    PriorityQueue<Integer> temp = val == 1 ? maxHeap : minHeap;
                    removeMap(temp , hashMap);
                }
            }
            if(hashMap.isEmpty()){
                bufferedWriter.write("EMPTY\n");
            }else {
                int n = removeMap(maxHeap, hashMap);
                bufferedWriter.write(n+" "+( !hashMap.isEmpty() ? removeMap(minHeap,hashMap) : n)+"\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }
    static int removeMap(PriorityQueue<Integer> q , Map<Integer, Integer> map){
        int result;
        while(true){
            result = q.poll();
            int cnt = map.getOrDefault(result, 0);

            if(cnt == 0) continue;
            if(cnt == 1) map.remove(result);
            else map.put(result, cnt-1);
            break;
        }
        return result;
    }
}
