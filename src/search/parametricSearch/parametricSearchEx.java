package search.parametricSearch;

/*
나무가
20m 17m 13m 10m 4그루가 있다.
지상으로 부터 Nm 지점을 잘라 내어
그 위로 잘려진 나무를 가져오려한다.

최소 Mm 의 나무를 가져오려할 때,
낭비되는 나무가 적도록 가져오는 높이 N을 구하여라

단, 나무는 N,M 은 모두 정수이고, 0<= M <=60
가져온 나무는 정수단위로 가져온다.
 */


import java.util.*;

public class parametricSearchEx {

    static int[] arr;
    static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        Arrays.sort(arr);
        int max = arr[arr.length-1];

        int start = 0; // 무조건 나무를 가져갈 수 있는 부분
        int end = max; // 무조건 나무를 가져갈 수 없는 부분

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            // mid위치에서 나무를 가져갈 수 있는지 없는지 확인, 가져갈 수 있다면 mid는 start에 없다면 end에 넣음
            if (check(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }

    static boolean check(int cuttingHeight) { // cuttingHeight위치에서 나무를 가져갈 수 있는지 없는지 확인

        long sum = 0;
        long result;
        long tree;

        for(int i = 0; i < arr.length; i++) {
            tree = arr[i];
            if (tree >= cuttingHeight) {
                result = tree - cuttingHeight;
                sum += result;
            }
        }
        if(sum >= m) {
            return true;
        }else {
            return false;
        }
    }
}