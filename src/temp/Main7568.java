package temp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		ArrayList<PersonSize> a1 = new ArrayList<PersonSize>();
		ArrayList<PersonSize> a2 = new ArrayList<PersonSize>();
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			a1.add(new PersonSize(a, b));
			a2.add(new PersonSize(a, b));
		}
		a1.sort(new Comparator<PersonSize>() {
			@Override
			public int compare(PersonSize o1, PersonSize o2) {
				
				return o2.getWeight()-o1.getWeight();
			}
		});
		
		a2.sort(new Comparator<PersonSize>() {
			@Override
			public int compare(PersonSize o1, PersonSize o2) {
				return o2.getHeight()-o1.getHeight();
			}
		});
		int ranking = 1;
		for(int i=0; i<N; i++) {
			if(a1.get(i).getHeight()==a2.get(i).getHeight()) {
				System.out.print(ranking+" ");
				ranking++;
			}
			else System.out.print(ranking+" ");
		}
		
	}

}
class PersonSize{
	int weight;
	int height;
	
	public PersonSize(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}
	
}