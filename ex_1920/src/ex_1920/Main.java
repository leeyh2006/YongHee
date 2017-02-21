package ex_1920;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Integer A[];
	static int X[];
	static int N, M;

	public static void main(String[] args) {

		int p = 0;
		int size=0;
		
		Set<Integer> set = new LinkedHashSet<Integer>();

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}
		size =set.size();
		A = new Integer[size];
		
		Iterator<Integer> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			A[p] = iterator.next();
			p++;
		}
		
		Arrays.sort(A);
		
		M = sc.nextInt();
		X = new int[M];
		for (int i = 0; i < M; i++) {
			X[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			if (Search(X[i], 0, size-1) == 0)
				System.out.println(0);
			else
				System.out.println(1);
		}
		sc.close();

	}

	public static int Search(int find, int low, int high) {
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] > find)
				high = mid - 1;
			else if (A[mid] < find)
				low = mid + 1;
			else
				return A[mid];
		}
		return 0;

	}
}
