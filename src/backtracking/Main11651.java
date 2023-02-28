package backtracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
public class Main11651 {
	static int N;
	static int M;
	
	static int[] used = new int[9];
	static int[] arr = new int[8];
	
	static StringBuilder sb = new StringBuilder();
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<8; i++) {
			used[i] = M;
		}
		
		Pi(0);
		System.out.println(sb);
	}

	private static void Pi(int r) {
		if(r==M) {
			int[] sortedArr = new int[9];
			boolean flag=true;
			sortedArr=Arrays.copyOf(arr, M);
			Arrays.sort(sortedArr);
			for(int i=0; i<M ; i++) {
				if(sortedArr[i]!=arr[i]) {flag=false; break;} 
			}
			if(flag) {
				for(int i=0; i<M;i++) {
					sb.append(arr[i] + " ");
				}
				sb.append("\n");
			}
			
			return ;
		}
		
		for(int i=1 ; i<=N ; i++) {
			if(used[i]>0) {
				arr[r]=i;
				used[i]--;
				Pi(r+1);
				for(int j=0; j<used.length; j++) {
					used[j] = M;
				}
			}
		}
	}
	
}*/


public class Main11651 {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dfs(0, "",1);
        System.out.println(sb);
    }

    public static void dfs(int count, String s, int start) {
        if (count == m) {
            sb.append(s);
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            dfs(count + 1, s+i+" ", i);
        }
    }
}