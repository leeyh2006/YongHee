package ex_11724;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N, E, ad[][];
		boolean Visit[];

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		E = sc.nextInt();
		ad = new int[N + 1][N + 1];
		Visit = new boolean[N + 1];

		for (int i = 1; i <= E; i++) {
			try {
				int t1 = sc.nextInt();
				int t2 = sc.nextInt();
				ad[t1][t2] = ad[t2][t1] = 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i =1; i<=N; i++){
			if(!Visit[i]){
				BFS(ad,Visit,N,E,i);
			}
		}
		System.out.println(cnt);
		

	}

	public static void BFS(int ad[][], boolean Visit[], int N, int E,int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		Hashtable<Integer, Boolean> hash = new Hashtable<Integer, Boolean>();

		q.offer(start);
		Visit[1] = true;
		while (!q.isEmpty()) {

			int size = q.size();
			for (int z = 0; z < size; z++) {
				int temp = q.poll();
				for (int i = 1; i <= N; i++) {
					if (ad[temp][i] == 1 && !Visit[i]) {
							Visit[i] = true;
							q.offer(i);
					}
					
				}

			}
			
		}
		cnt++;
	}

}
