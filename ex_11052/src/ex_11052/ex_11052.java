package ex_11052;

import java.util.Scanner;

public class ex_11052 {
	public static void main(String[] ar) {
		int N = 0, dp[],input[];
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		dp = new int[N+1];

		input = new int [N+1];
		

		for (int i = 1; i <= N; i++){
			input[i]= sc.nextInt();
			
		}
		dp[0]=0;
		dp[1]=input[1];
	
		for(int i=2;i<=N;i++){
			
			dp[i]=dp[i-1]+input[1];
			for(int k=2;k<=i;k++){
				System.out.println("I "+ i+" "+ "K "+ k);
				System.out.println(dp[i-k]);
				dp[i]=max(dp[i-k]+input[k],dp[i]);
			}
		}
		//System.out.println(dp[N]);
		

		sc.close();

	}	
	public static int max(int a,int b){
		return a>b ? a:b;
		
		
	}
}
