package ex_1149;

import java.util.Scanner;

public class Main {

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		HOME H[];
		int dp[][];
		int R, G, B;

		int Home_Count;
		Home_Count = sc.nextInt();

		H = new HOME[Home_Count];

		dp = new int[1000][Home_Count];

		for (int i = 0; i < Home_Count; i++) {
			R = sc.nextInt();
			G = sc.nextInt();
			B = sc.nextInt();
			H[i] = new HOME(R, G, B);
			// System.out.print(H[i].R + " " + H[i].G + " " + H[i].B + "\n");

		}
		dp[0][1] = H[0].R;
		dp[0][2] = H[0].G;
		dp[0][3] = H[0].B;

		for (int i = 1; i <= Home_Count; i++) {
			if (dp[i][2] > dp[i][3])
				dp[i - 1][1] = dp[i][3] + H[i].R;
			else
				dp[i - 1][1] = dp[i][2] + H[i].R;

			if (dp[i][1] > dp[i][3])
				dp[i - 1][2] = dp[i][3] + H[i].G;
			else
				dp[i - 1][2] = dp[i][1] + H[i].G;

			if (dp[i][1] > dp[i][2])
				dp[i - 1][3] = dp[i][2] + H[i].B;
			else
				dp[i - 1][3] = dp[i][1] + H[i].B;
		}
		System.out.print(temp(dp[Home_Count][0], dp[Home_Count][1],
				dp[Home_Count][2]));
		// System.out.println(dp[Home_Count][1] + " " + dp[Home_Count][2] + " "
		// + dp[Home_Count][3]);
	}

	public static int temp(int a, int b, int c) {
		if (a < b && a < c) {
			return a;

		} else if (b < a && b < c)
			return b;
		else {
			return c;
		}

	}
}

class HOME {
	int R, G, B;

	public HOME(int R, int G, int B) {
		this.R = R;
		this.G = G;
		this.B = B;
	}

}
