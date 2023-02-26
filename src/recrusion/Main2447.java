package recrusion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2447 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] position = new int [N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				position[i][j]=0;
			}
		}
		
		removeAndPrint(0, 0, N , position);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				bw.write(position[i][j]==0?"*":" ");
			}
			bw.write("\n");
		}
		bw.close();
	}
	
	// 스타트 포인트(0 ,0 ) + 크기입력(n) = 삭제
	private static void removeAndPrint (int startX, int startY ,int size, int[][] position) {
		int p=size/3;
		
		if(p!=0) {
		for(int i=p+startX;i<p*2+startX;i++) {
			for(int j=p+startY; j<p*2+startY;j++) {
				position[i][j]=1;
			}
		}
		removeAndPrint(startX, startY, p, position);
		removeAndPrint(startX+2*p, startY+p, p, position);
		removeAndPrint(startX+2*p, startY, p, position);
		removeAndPrint(startX+p, startY, p, position);
		removeAndPrint(startX, startY+p, p, position);
		removeAndPrint(startX, startY+2*p, p, position);
		removeAndPrint(startX+p, startY+2*p, p, position);
		removeAndPrint(startX+2*p, startY+2*p, p, position);
		}
		
	}
}
