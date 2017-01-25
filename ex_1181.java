package ex_1181;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	private static Scanner sc;
	private static int N;

	public static void main(String[] ar) {
		String letter;

		sc = new Scanner(System.in);

		// PriorityQueue<Alphabet> q = new PriorityQueue<Alphabet>(new SORT());
		TreeSet<Alphabet> q = new TreeSet<Alphabet>(new SORT());

		Alphabet al;

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			letter = sc.next();
			al = new Alphabet(letter, letter.length());
			q.add(al);
		}
		/*
		 * for (Alphabet i : q){ System.out.println((Alphabet)i); }
		 */

		Iterator<Alphabet> it = q.iterator();
		
		while(!q.isEmpty()){
			Alphabet aa = q.pollFirst();
			System.out.println(aa.Alpha);
		}
	}
}

class Alphabet {
	String Alpha;
	int length;

	public Alphabet(String Alpha, int length) {
		this.Alpha = Alpha;
		this.length = length;
	}
}

class SORT implements Comparator<Alphabet> {

	public int compare(Alphabet a1, Alphabet a2) {
		// TODO Auto-generated method stub
		if (a1.length < a2.length) {
			return -1;
		} else if (a1.length == a2.length) {
			return a1.Alpha.compareTo(a2.Alpha);
		} else
			return 1;
	}
}
