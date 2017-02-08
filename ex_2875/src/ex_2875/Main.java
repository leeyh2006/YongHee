package ex_2875;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N, M, K; // 여학생 1 명 남학생 2명 한팀
		int count=0;
		int tmp_N,tmp_M,tmp_count;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 여학생
		M = sc.nextInt();//남학생
		K = sc.nextInt();// 인턴쉽 참여 인원
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
