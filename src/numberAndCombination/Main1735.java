package numberAndCombination;

import java.util.Scanner;

public class Main1735 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
		
		int Gcd=EculidGcd(arr[1],arr[3]);
		int denom=(arr[1]*arr[3]/Gcd);
		int numer=(arr[0]*arr[3]/Gcd)+(arr[2]*arr[1]/Gcd);
		int a =EculidGcd(denom,numer);
		System.out.println(numer/a + " " + denom/a);

	}

	private static int EculidGcd(int i, int j) {
		int max=Math.max(i, j);
		int min=Math.min(j, i);
		while(true) {
			if(max%min==0) break;
			int tmp = max%min;
			max=min;
			min=tmp;
		}
		return min;
	}

}
