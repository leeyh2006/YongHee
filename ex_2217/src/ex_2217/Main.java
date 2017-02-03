package ex_2217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ad[], k=0, N, max,temp=0;

		N = sc.nextInt();

		ad = new int[N];
	

		for (int i = 0; i < N; i++) {
			ad[i] = sc.nextInt();
		}
		Arrays.sort(ad);
		max=ad[0];
		for(int i =0;i<N;i++){
			temp = ad[i]*(N-i);
			max=Max(temp,max);
		}
		System.out.println(max);
		sc.close();
	}
	public static int Max(int a,int b){
		return a>b?a:b;
	}
}
