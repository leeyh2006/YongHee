package ex_2875;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N, M, K; // ���л� 1 �� ���л� 2�� ����
		int count=0;
		int tmp_N,tmp_M,tmp_count;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// ���л�
		M = sc.nextInt();//���л�
		K = sc.nextInt();// ���Ͻ� ���� �ο�
		tmp_N =N;
		tmp_M=M;
		tmp_count = count;
		for(int i =0;i<=K;i++){
			tmp_N=N-(K-i);
			tmp_M=M-i;
			while(true){
				tmp_N -=2;tmp_M-=1;
				if(tmp_N <0 ||tmp_M<0 )break;
				count++;
			}
			tmp_count = MAX(tmp_count,count);
			count =0;
		}
		System.out.println(tmp_count);
		
	}
	public static int MAX(int a, int b){
		return a>b?a:b;
	}
}
