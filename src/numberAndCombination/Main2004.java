package numberAndCombination;

import java.util.Scanner;

public class Main2004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int tmpa=a;
		int tmpb=b;
		int tmpab1=a-b;
		int tmpab2=a-b;
		
		int count5a=0;
		int count5b=0;
		
		int count2a=0;
		int count2b=0;
		
		int count5ab=0;
		int count2ab=0;
		
		while(true) {
			tmpab1/=5;
			count5ab+=tmpab1;
			if(tmpab1==0) break;
		}
		while(true) {
			tmpab2/=2;
			count2ab+=tmpab2;
			if(tmpab2==0) break;
		}
		while(true) {
			tmpa/=5;
			count5a+=tmpa;
			if(tmpa==0) break;
		}
		while(true) {
			a/=2;
			count2a+=a;
			if(a==0) break;
		}
		while(true) {
			tmpb/=5;
			count5b+=tmpb;
			if(tmpb==0) break;
		}
		while(true) {
			b/=2;
			count2b+=b;
			if(b==0) break;
		}
		System.out.print(Math.min(count2a-count2b-count2ab, count5a-count5b-count5ab));

	}

}
