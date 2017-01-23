package ex_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, ad[][],count =0;
	static boolean visit[][];

	static Point p ,in;

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String matrix = "";

		p = new Point();



		N = sc.nextInt();
		M = sc.nextInt();

		ad = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			matrix = sc.next();
			StringBuilder str = new StringBuilder(matrix);
			str.insert(0, " ");
			for (int j = 1; j <= M; j++) {
				ad[i][j] = Integer.parseInt(str.toString().charAt(j) +"");

			}
		}
		//		 for(int i= 1; i<=N;i++){
		//			 for(int j =1 ; j<=M;j++){
		//			 System.out.print(ad[i][j]);
		//			 }
		//			 System.out.println();
		//			 }
		BFS();



	}

	public static void BFS() throws CloneNotSupportedException {
		Queue<Point> q = new LinkedList<Point>();

		in = p.clone();

		p.x = 1;
		p.y = 1;
		p.l = 0;
		
		
		in.x =1;
		in.y=1;
		in.l=0;


		q.offer(p);

		while (!q.isEmpty()) {
			p = q.poll();
			in = p.clone();
			
			visit[1][1]=true;
			System.out.println( p.x +","+ p.y+"에서");
				if (p.y<=M-1 && (ad[p.x][p.y + 1] != 0 && !visit[p.x][p.y + 1])) {
					visit[p.x][p.y+1]=true;
					in.x=p.x;
					in.y =(p.y+1);
					in.l++;
					System.out.println(" "+in.x+","+in.y +"로");
					q.offer(in);
				}
				 if(p.x<= N-1 && (ad[p.x+1][p.y] != 0 && !visit[p.x+1][p.y])){
						visit[p.x+1][p.y]=true;
						in.x=p.x+1;
						in.y=p.y;
						in.l++;
						System.out.println(" "+in.x+","+in.y +"로");
						q.offer(in);

					}
				 if(p.y >=1 &&(ad[p.x][p.y-1]!= 0 && !visit[p.x][p.y-1])){
					 visit[p.x][p.y-1]=true;
					in.x=p.x;
					in.y = p.y-1;
					in.l++;
					System.out.println(" "+in.x+","+in.y +"로");
					q.offer(in);

				}   
				 if(p.x >=1 &&(ad[p.x-1][p.y]!= 0 && !visit[p.x-1][p.y])){
					visit[p.x-1][p.y]=true;
					in.x = p.x-1;
					in.y=p.y;
					in.l++;
					System.out.println(" "+in.x+","+in.y +"로");
					q.offer(in);
				}
			
				System.out.println("p.L ="+ p.l);
				if(in.x == N && in.y==M)break;
			}
		

	}
}

class Point implements Cloneable{

	int x, y, l; // x,y,l que 맵핑
	public Point clone() throws CloneNotSupportedException{
		return (Point) super.clone();

	}
}