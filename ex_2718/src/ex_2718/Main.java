package ex_2718;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Test_case,input,dp[];
		
		Scanner sc = new Scanner(System.in);
		
		dp = new int [1000];
		int m[] ={3,2};
		
		Test_case = sc.nextInt();
		int sum=0;
		while(Test_case-->0){
			input = sc.nextInt();
			dp[2]=5;dp[1]=1;dp[0]=1;
	
			for (int i =3;i<=input;i++){
				dp[i]=dp[i-1]+4*dp[i-2];
				for(int k=3; k<=i;k++)dp[i]+= (m[k % 2] * dp[i-k]);        
			}
			
			System.out.println(dp[input]);
			
		}

	}

}
