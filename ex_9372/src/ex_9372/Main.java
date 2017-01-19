package ex_9372;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) {
		
		 int ad[][],V,E;
		 boolean visit[];
		// TODO Auto-generated method stub
		int test_case=0;
		Scanner sc = new Scanner(System.in);
		
		test_case= sc.nextInt();
		while(test_case -- > 0){
			V=sc.nextInt();
			E=sc.nextInt();
			
			ad = new int[V+1][V+1];
			visit = new boolean[V+1];	
			
			for(int i =0;i<E;i++){
				int t1=sc.nextInt();
				int t2=sc.nextInt();
				
				ad[t1][t2]=ad[t2][t1]=1;
				
				
			}
			BFS(1,ad,visit,V);
			
		}
	
		

	}
	
	public static void BFS(int i,int ad[][],boolean visit[],int V){
		int count =0;
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		HashMap<Integer,Boolean> hash = new HashMap<Integer, Boolean>();
		
		que.offer(i);
		
		while(!que.isEmpty()){
		
			int temp = que.poll();
			visit[temp]= true;

			for(int j=1; j<=V; j++){
				if(ad[temp][j] == 1 && visit[j]==false){
						que.offer(j);
						visit[j]=true;
						count++;
				}
			}
			
			
		}
		
		System.out.println(count);
	}
	

}
