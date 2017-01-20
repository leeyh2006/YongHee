package ex_7576;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, column, length;

}

public class Main {
	static int ad[][], row, column,count=1;
	static Point p[];
	static boolean Visit[][];

	static Point P_in, P_d;

	public static void Check(Point p, boolean B[][], int a, int b, int AD[][]) {
		AD[a][b] = 1;
		B[a][b] = true;
		P_d.row = a;
		P_d.column = b;
		P_d.length +=1;
	}

	public static void BFS() {

		Queue<Point> que = new LinkedList<Point>();

		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int sum=0;

		P_d.row = 1;
		P_d.column = 1;
		P_d.length = 1;
		que.offer(P_d);

		while (!que.isEmpty()) {
			P_d = que.poll();
			Visit[row][column]=false;
			Visit[1][1]=false;
			sum=0;
			System.out.println(P_d.row+" , "+P_d.column);
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= column; j++) {
				System.out.println("ad["+i+"]["+j+"]="+ad[i][j]);
					if (ad[i][j] == 1) {
						if (i + 1 <= row && ad[i + 1][j] == 0 && !Visit[i+1][j]) { // 아랫 값이 0이면 1로
							if(!hash.containsKey(P_d.row)){
								Check(P_d, Visit, i + 1, j, ad);
								que.offer(P_d);
								hash.put(P_d.row, P_d.column);
							}
							System.out.println("아랫값 걸림["+(i+1)+"]["+j+"]");
						}
						if (i - 1 > 0 && ad[i - 1][j] == 0 && !Visit[i-1][j]) {// 위 에값이 0이면
							if(!hash.containsKey(P_d)){
								Check(P_d, Visit, i - 1, j, ad);
								que.offer(P_d);
								hash.put(P_d.row, P_d.column);
							}

							System.out.println("윗값  걸림["+(i-1)+"]["+j+"]");
						}
						if (j + 1 <= column && ad[i][j + 1] == 0 && !Visit[i][j+1]) { // 오른쪽 값이 0이면
							if(!hash.containsKey(P_d)){
								Check(P_d, Visit, i, j + 1, ad);
								que.offer(P_d);
								hash.put(P_d.row, P_d.column);
							}
							System.out.println("오른쪽값 걸림["+i+"]["+(j+1)+"]");
						}
						if (j - 1 > 0 && ad[i][j - 1] == 0 && !Visit[i][j-1]) { // 왼쪽 값이 0이
							if(!hash.containsKey(P_d)){
								Check(P_d, Visit, i, j - 1, ad);
								que.offer(P_d);
								hash.put(P_d.row, P_d.column);
							}
							System.out.println("왼쪽값 걸림["+i+"]["+(j-1)+"]");
						}
					}
				}
			}
			for(int i =1; i<=row;i++){
				for(int j =1 ; j<=column;j++){
					sum+=ad[i][j];
				}
			}
			if(sum == column*row)
				{
				System.out.println("count = "+ count);
				break;
				}

			//			System.out.println("count = "+ count);

		}



	}

	public static void main(String[] ar) {
		int data = 0;
		Scanner sc = new Scanner(System.in);

		column = sc.nextInt();
		row = sc.nextInt();
		ad = new int[row + 1][column + 1];
		Visit = new boolean[row + 1][column + 1];
		P_in = new Point();
		P_d = new Point();

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				data = sc.nextInt();
				ad[i][j] = data;
			}
		}

		BFS();
		System.out.println();
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				System.out.print(ad[i][j] + " ");
			}
			System.out.println();

		}
		sc.close();

	}

}
