package search.parametricSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main2805 {

    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(tree(M));

    }

    public static long sum(int T) {

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > T) {
                sum += arr[i] - T;
            }
        }

        return sum;

    }

    public static int tree(int T) {

        int low = 1;
        int high = arr[arr.length - 1];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (sum(mid) < T) {
                high = mid - 1;
            } else if (sum(mid) > T) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return high;

    }

}