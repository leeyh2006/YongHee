package ex_10825;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int N;
	private static Scanner sc;

	public static void main(String[] ar) {
		String st_name;
		int kor = 0, eng = 0, math = 0;
		sc = new Scanner(System.in);
		N = sc.nextInt();

		PriorityQueue<Student> q = new PriorityQueue<Student>(
				new AscendingCompare());

		Student s;
		for (int i = 0; i < N; i++) {
			st_name = sc.next();
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			s = new Student(st_name, kor, eng, math);
			q.add(s);
		}

		for (int i = 0; i < N; i++) {
			Student ss = q.poll();
			System.out.println(ss.name);

		}

	}
}

class Student {
	String name;
	int kor;
	int eng;
	int math;

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}

class AscendingCompare implements Comparator<Student> {

	public int compare(Student s1, Student s2) {
		if (s1.kor > s2.kor) {
			return -1;
		} else if (s1.kor == s2.kor) {
			if (s1.eng > s2.eng) {
				return 1;
			} else if (s1.eng == s2.eng) {
				if (s1.math > s2.math) {
					return -1;
				} else if (s1.math == s2.math) {
					return s1.name.compareTo(s2.name);
				} else
					return 1;
			} else {
				return -1;
			}
		} else {
			return 1;
		}
		// TODO Auto-generated method stub
	}
}