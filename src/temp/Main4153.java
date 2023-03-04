package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		StringTokenizer st;
		
		while(true) {
			st=new StringTokenizer(br.readLine(), " ");
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			if(arr[0]==0&&arr[1]==0&&arr[2]==0) break;
			
			Arrays.sort(arr);
			
			if(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2])
				System.out.println("right");
			else System.out.println("wrong");
		}

	}

}
