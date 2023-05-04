//package search.binarySearch;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main1654 {
//    static int N,M,answer;
//    static int[] arr;
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        N = Integer.parseInt(stringTokenizer.nextToken());
//        M = Integer.parseInt(stringTokenizer.nextToken());
//        arr = new int[N];
//        int arrmax=0;
//        for(int i=0; i<N; i++){
//            arr[i] = Integer.parseInt(bufferedReader.readLine());
//            if(arrmax<arr[i]) arrmax=arr[i];
//        }
//        int min=0;
//        checker(min, max);
//        System.out.println(answer);
//    }
//
//    private static void checker(int min,int max) {
//        if(min+1==max || min==max) {
//            answer=min;
//            return;
//        }
//        int mid = (max+min)/2;
//        int sum=0;
//        for(int i = 0; i < arr.length; i++) {
//            sum += arr[i] / mid;
//        }
//        if(sum >= M){
//            checker(mid, max);
//        } else if(sum<M){
//            checker(min, mid);
//        }
//    }
//}

package search.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        long max = 0;

        // 입력과 동시에 해당 랜선의 길이가 최댓값인지를 확인하고 max를 갱신
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }


        // 반드시 max에서 +1 값이어야 한다.
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {

            // 범위 내에서 중간 길이를 구한다.
            mid = (max + min) / 2;


            long count = 0;

            // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.

            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            /*
             *  [upper bound 형식]
             *
             *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */
            if(count < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }


        }

        // UpperBound로 얻어진 값(min)에 -1이 최대 길이가 된다.
        System.out.println(min - 1);
    }
}