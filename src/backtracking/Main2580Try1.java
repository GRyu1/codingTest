package backtracking;

/* [Idea]
 * 
 *  해당 칸 0 or N ? 0   -> box check row check col check & put num 
 *                 : N -> 다음 칸 조사.
 *                 
 * [Error]
 *  1.숫자 searching 방식 , 다수의 후보 숫자가 나올때 다수의 재귀가 필요하지만,
 *   해당 코드는 다수의 후보 숫자가 나올시 제일 앞에 나오는 숫자 기준으로 재귀 호출함.
 * 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2580Try1 {
	static int[][] arr = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<int[]> al = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					int[] tmp = {i , j};
					al.add(tmp);
				}
			}
		}
		
		sudoku(al,al.get(0),0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9;j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.close();
	}

	private static void sudoku(ArrayList<int[]> al, int[] target, int depth) {
		int xIdx = target[0];
		int yIdx = target[1];
		
		int[] check = new int [10];
		check[0]=100;
		for(int i=0 ; i<9; i++) {
			check[arr[xIdx][i]]++;
			check[arr[i][yIdx]]++;
		}
		for(int i = xIdx/3*3 ;i<xIdx/3*3+3 ;i++ ) {
			for(int j= yIdx/3*3; j<yIdx/3*3+3 ; j++) {
				check[arr[i][j]]++;
			}
		}
		
		int count=0;
		int countidx=0;
		for(int i=0;i<10;i++) {
			if(check[i]==0) {
				count++;
				countidx=i;
			}
		}
		if(count == 1) {
			arr[xIdx][yIdx] = countidx;
			if(depth==al.size()-1) return;
			sudoku(al,al.get(depth+1), depth+1);
		}
		
	}

}
