package numberAndCombination;

import java.util.Scanner;

public class Main5086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==0&&b==0) break;
			
			System.out.println(b%a==0? "factor" : a%b==0 ? "multiple" : "neither" );
		}

	}

}
