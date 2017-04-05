package ex_1472;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String input;
		int to_int[];
		Scanner sc = new Scanner(System.in);

		input = sc.next();
		to_int = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			to_int[i] = Character.digit(input.charAt(i), 10);
		}
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (to_int[i] < to_int[j]) {
					int temp = 0;
					temp = to_int[i];
					to_int[i] = to_int[j];
					to_int[j] = temp;
				}
			}
		}

		for (int i : to_int)
			System.out.print(i);
		sc.close();

	}
}
