package backtracking;

import java.util.Scanner;

public class Main9663 {
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] arr = new boolean [N][N];
		
		for(int i=0 ; i<N; i++) {
			for(int j=0; j<N; j++) {
				dfs(arr, i , j , N ,0);
				
				for(int k=0; k<N ; k++) {
					for(int l=0; l<N; l++) {
						arr[k][l]=false;
					}
				}
			}
		}
		System.out.println(count);
	}

	private static void dfs(boolean[][] arr, int startX, int startY ,int N, int depth) {
		
		if(arr[startX][startY]) {
			return;
		}
		for(int i=0; i<N ; i++) {
			arr[startX][i]=true;
			arr[i][startY]=true;		
		}
		int x = startX;
		int y = startY;
		while(x<N&&y<N) {
			arr[x++][y++] = true;
		}
		x = startX;
		y = startY;
		while(0<=x&&y<N) {
			arr[x--][y++] = true;
		}
		x = startX;
		y = startY;
		while(0<=x&&0<=y) {
			arr[x--][y--] = true;
		}
		x = startX;
		y = startY;
		while(x<N&&0<=y) {
			arr[x++][y--] = true;
		}
		
		depth++;
		
		if(depth==N) {
			count++;
		}
			
		for(int i = 0 ; i<N ; i++ ) {
			for(int j= 0; j<N; j++) {
				dfs(arr, i, j , N , depth);
			}
		}
		
	}

}
