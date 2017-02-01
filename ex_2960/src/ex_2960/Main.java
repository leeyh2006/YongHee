package ex_2960;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,K;
	static boolean visit[];
	static int result;
	
	public static void main(String []ar){
		Scanner sc = new Scanner(System.in);
		
	
		Queue<Integer> q = new LinkedList<Integer>();
		
		N= sc.nextInt();
		K= sc.nextInt();
		visit = new boolean[N+1];
		
		for(int i =2 ;i<=N;i++){
			if(visit[i])continue;
			visit[i]=true;
			q.offer(i);
			for(int j = i;i*j<=N;j++){
				if(visit[i*j])continue;
				visit[i*j]=true;
				q.offer(i*j);
			}
		}
		for(int i =0; i<K;i++){
			result=q.poll();
		}
		System.out.println(result);
	}
}
