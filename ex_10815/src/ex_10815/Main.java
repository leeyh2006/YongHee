package ex_10815;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = null;
	static int N, M;
	static int A_N[], A_M[];

	public static void main(String[] args) {
		
		StringBuilder st= new StringBuilder();
		
		sc = new Scanner(System.in);

		N = sc.nextInt();
		A_N = new int[N];
		For(A_N, N);
		Arrays.sort(A_N);

		M = sc.nextInt();
		A_M = new int[M];
		For(A_M, M);

		for (int i = 0; i < M; i++) {
			if(Search(A_M[i], 0, N-1)==0)st.append(0+" ");
			else st.append(1+" ");
		}
		System.out.println(st.toString());

	}

	public static int Search(int find, int low, int high) {
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (A_N[mid] > find) {
				high = mid - 1;
			} else if (A_N[mid] < find)
				low = mid + 1;
			else {
				return A_N[mid];
			}
		}
		return 0;

	}

	public static void For(int arr[], int count) {
		for (int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();

		}
	}
}
