package numberAndCombination;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int s=0;
		s+=N/5;
		s+=N/25;
		s+=N/125;
		
		System.out.println(s);
	}
}
