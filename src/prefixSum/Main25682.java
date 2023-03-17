package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main25682{
	static int N;
	static int M;
	static int K;
	static char[][] chessBase;
	;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	K=Integer.parseInt(st.nextToken());
    	
    	
    	chessBase = new char[N][M];
    	
    	for(int i=0; i<N; i++) {
    		String str = br.readLine();
    		for(int j=0; j<M ; j++) {
    			chessBase[i][j]=str.charAt(j);
    		}
    	}
    	
    	System.out.println(Math.min(scoreChecker('B'), scoreChecker('W')));
   	}

	private static int scoreChecker(char c) {
		int result=Integer.MAX_VALUE;
		int value;
		int[][] score = new int[N+1][M+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if((i+j)%2==0) {
					value=chessBase[i][j] != c ? 1 : 0;
				}else {
					value=chessBase[i][j] == c ? 1 : 0;
				}
				score[i+1][j+1] = score[i][j+1] + score[i+1][j] - score[i][j] + value;
			}
		}
		
		for(int i = 1; i <= N - K + 1; i++) {
			for(int j = 1; j <= M - K + 1; j++) {
				result = Math.min(result, score[i+K-1][j+K-1] - score[i+K-1][j-1] - score[i-1][j+K-1] + score[i-1][j-1]);
			}
		}
		
		return result;
	}

 }
