package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Person> arrlist = new ArrayList<Person>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine());
			arrlist.add(new Person(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		arrlist.sort(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge()-o2.getAge();
			}
		});
		for(int i=0; i<arrlist.size();i++) {
			bw.write(arrlist.get(i).getAge()+" "+arrlist.get(i).getName()+"\n");
		}
		bw.close();
	}
	
	
}

class Person {
	int age;
	String name;
	
	Person(int age, String name){
		this.age=age;
		this.name=name;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	
}