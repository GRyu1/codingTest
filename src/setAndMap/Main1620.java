package setAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/* String 으로 받은 값이 문자를 의미하는가 숫자를 의미하는가.
 * 구별 매소드.
 * 
 * hashMap key value 쌍 역전.
 * */

public class Main1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String , Integer> hashStringtoInt = new HashMap<String ,Integer>();
		HashMap<Integer , String> hashInttoString = new HashMap<Integer ,String>();
		
		for(int i=0; i<N;i++) {
			String str = br.readLine();
			hashStringtoInt.put(str, i+1);
			hashInttoString.put(i+1, str);
		}
		
		for(int i=0; i<M ; i++) {
			String str = br.readLine();
			if(isStringNumber(str)) {
				bw.write(hashInttoString.get(Integer.parseInt(str)) + "\n");
			}else {
				bw.write(hashStringtoInt.get(str) + "\n");
			}
		}
		
        bw.close();
	}
	
	public static boolean isStringNumber(String s) {
		   try {
		       Double.parseDouble(s);
		       return true;
		   }
		   catch (NumberFormatException e) {
		       return false;
		   }
		}
}
