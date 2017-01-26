package ex_9251;

import java.util.Scanner;

public class Main {
	public static Scanner sc;

	public static void main(String[] ar) {
		StringBuilder sb,sb1;

		String str, str2;
		char str_c[], str_c2[];
		int LCS[][];

		sc = new Scanner(System.in);

		str = sc.next();
		str2 = sc.next();

		sb = new StringBuilder(str);
		sb.insert(0, "0");

		sb1 = new StringBuilder(str2);
		sb1.insert(0, "0");
		
		str =sb.toString();
		str2=sb1.toString();
		

		LCS = new int[str.length()][str2.length()];

		str_c = new char[str.length()];
		str_c2 = new char[str2.length()];

		str_c = str.toCharArray();
		str_c2 = str2.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			LCS[i][0] = 0;
		}
		for (int j = 0; j < str2.length(); j++) {
			LCS[0][j] = 0;
		}

		for (int i = 1; i < str_c.length; i++) {
			for (int j = 1; j < str_c2.length; j++) {
				if (str_c[i - 1] == str_c2[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					if (LCS[i][j - 1] >= LCS[i - 1][j])
						LCS[i][j] = LCS[i][j - 1];
					else
						LCS[i][j] = LCS[i - 1][j];
				}
			}
		}
		System.out.print(LCS[str_c.length - 1][str_c2.length - 1]);
	}
}
