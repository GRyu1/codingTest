package geomatics01;

import java.util.Scanner;

public class Main1085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		System.out.println(Math.min(Math.min(Y, Math.abs(H-Y)), Math.min(X, Math.abs(W-X))));
		

	}

}
