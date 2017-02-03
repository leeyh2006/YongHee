package ex_11399;

import java.util.Scanner;

public class Main {

	public static void main(String []ar){
		Scanner sc= new Scanner(System.in);
		int sum=0;
		int N,ad[],dp[];
		N= sc.nextInt();
		ad= new int[N];
		dp=new int [N];
		for(int i = 0;i<N;i++)ad[i]=sc.nextInt();
		
		for(int i =0; i<N;i++){
			for(int j =0;j<N;j++){
				if(ad[i]<ad[j])
				{
					int temp;
					temp = ad[i];
					ad[i]=ad[j];
					ad[j]=temp;
				}
			}
		}
		while(N-->0){
			for(int i =0 ;i<=N;i++){
				dp[N]+=ad[i];
			}
			sum+=dp[N];
		}
		System.out.println(sum);
	}	
}
