package ex_12761;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int ad[][],V,E;
	static boolean visit[];
	
	static int N,M;
	static int SkyKongA,SkyKongB;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try{
			
			SkyKongA = sc.nextInt();
			SkyKongB = sc.nextInt();
			
			N=sc.nextInt();
			M=sc.nextInt();
			
			visit =new boolean[10001];
			
		}catch(Exception e){};
		BFS(N);
		

	}
	
	public static void BFS(int start){
		
		int count=0,a=0;
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		
		que.offer(start);
		
		while(!que.isEmpty()){
			int cur=que.poll();
			visit[cur]=true;
			if(cur ==M){

				break;
			}
			
			int Way[]={-1,1,-SkyKongA,SkyKongA,-SkyKongB,SkyKongB,cur*SkyKongA,cur*SkyKongB};
			
			for(int i =0;i<Way.length;i++){
				if(i>=0 && i<=5) {
					count = cur+Way[i];
					System.out.print("cur = "+cur);
					System.out.print("if ="+i);
					System.out.println("count = "+ count);
				}
				else {
					count = Way[i];
					System.out.print("cur = "+cur);
					System.out.print("else ="+i);
					System.out.println("count = "+ count);
				}
				if(count >=0 && count <=10000 && visit[count]==false){
					System.out.println("que count"+count);
					visit[count]=true;
					que.offer(count);
					System.out.println("visit ["+count+"]="+visit[count]);
				}
			}
		}
	}

}
