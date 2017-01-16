package ex_2163;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=0, M=0,dp[][];
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		dp=new int[N+1][M+1];
		for(int i =1;i<=N;i++){
			dp[i][1]=i-1;
		}
		for(int i = 1 ; i <=N; i++){
			for(int j =2; j<=M;j++){
				dp[i][j]=dp[i][j-1]+i;
				
			}
		}
		System.out.println(dp[N][M]);

	}

}
