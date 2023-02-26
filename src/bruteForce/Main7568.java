package bruteForce;

import java.util.Scanner;

public class Main7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int idx=1;
		int i=665;
		while(true) {
			i++;
			String str=i+"";
	
			if(str.indexOf("666")==-1) continue;
			else{
				if(N==idx) {
					System.out.println(str);
					break;
				}
				idx++;
			}
		}
		
	}
}