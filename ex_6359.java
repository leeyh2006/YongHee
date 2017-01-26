package ex_6359;

import java.util.Scanner;

public class Main {
	public static void main(String[] ar) {
		int N;
		int dp[][];
		int count = 2;

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = 0;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i * j <= N) {
					if (dp[i-1][i * j] == 1) {
						dp[i-1][i * j] = 0;
					} else {
						dp[i-1][i * j] = 1;
					}
				} else
					continue;
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(dp[N][i] + " ");
		}
	}
}
