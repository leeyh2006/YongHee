package ex_10814;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int N;

	public static void main(String[] ar) {

		String name;
		int age;

		PriorityQueue<User> q = new PriorityQueue<User>(new SORT());
		User us;

		sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			age = sc.nextInt();
			name = sc.next();
			us = new User(name, age, i);
			q.add(us);
		}
		for (int i = 0; i < N; i++) {
			User ss = q.poll();
			System.out.print(ss.age + " " + ss.name + "\n");
		}
	}

}

class User {
	String name;
	int age, count;

	public User(String name, int age, int count) {
		this.name = name;
		this.age = age;
		this.count = count;

	}
}

class SORT implements Comparator<User> {

	public int compare(User o1, User o2) {
		if (o1.age < o2.age) {
			return -1;
		}
		else if(o1.age == o2.age){
			if(o1.count <o2.count){
				return -1;
			}
			else{
				return 1;
				
			}
		}
		else{
			return 1;
			
		}
		// TODO Auto-generated method stub
	}

}