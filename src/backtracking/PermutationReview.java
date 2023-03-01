package backtracking;

/* [IDEA]
 *  BackTracking
 *  
 *  nPr ->1-n까지의 숫자로 r칸에 숫자 채우기
 *  
 *  ex)4P3
 *  [ ] [ ] [ ]
 *   - 1번칸 1~4중 사용하지 않은 숫자 넣기
 *   ->재귀 호출
 *    재귀 대상 : N번칸에 1~4중 사용하지 않은 모든 숫자 넣어보기. 숫자를 넣은 후 사용됨으로 표시.
 *    재귀 횟수 : r번칸 까지 - 재귀 횟수를 check해주는 변수사용.
 *    재귀 반납 : 1) r-1번 재귀 매소드 한테 r번째가 사용한 숫자 i를 사용함으로 표시.
 *              2) r번칸의 숫자값.
 *    재귀 반납 후 : r-1번째 실행 매소드에선 i를 다시 사용하지 않음으로 변경.
 *    			  (r번째 i말고 다른 가능 한 값을 위한 재귀를 위해)
 *    
 *   -재귀 완료 후 출력. 
 *   
 *   
 *   
 * */



import java.util.Scanner;

public class PermutationReview {
	static StringBuilder sb = new StringBuilder();
	static boolean[] used = new boolean[10];
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		
		arr = new int[R];
		
		permutation(N, R, 0);
		System.out.println(sb);
	}

	private static void permutation(int n, int r , int depth) {
		if(depth == r) {
			for(int i=0; i<r ; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n ; i++) {
			if(!used[i]) {
				arr[depth]=i;
				used[i]=true;
				permutation(n , r , depth+1);
				used[i]=false;
			}
		}
	}

}
