package ex_9095;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, M, dp[];
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[15];

		dp[1] = 1;
		while (N-- > 0) {
			M = sc.nextInt();

			for (int i = 2; i <=N; i++) {
				if (i - 1 >= 0)
					dp[i] += dp[i - 1];
				if (i - 2 >= 0)
					dp[i] += dp[i - 2];
				if (i - 3 >= 0)
					dp[i] += dp[i - 3];

			}
			System.out.println(dp[M]);

		}
	}

}
