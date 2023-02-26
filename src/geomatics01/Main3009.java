package geomatics01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] countx = new int[1001];
		for(int i=0;i<1000;i++) {
			countx[i]=0;
		}
		int[] county = new int[1000];
		for(int i=0;i<1000;i++) {
			county[i]=0;
		}
		
		int x=0;
		int y=0;
		
		for(int i=0; i<3; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			countx[a]++;
			county[b]++;
		}
		
		for(int i=0; i<1000;i++) {
			if(countx[i]==1) x=i;
			if(county[i]==1) y=i;
		}
		System.out.println(x+" "+y);
	}
}
