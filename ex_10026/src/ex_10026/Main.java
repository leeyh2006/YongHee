package ex_10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int ans = 0,ans1=0;
	static int ad[][];
	static boolean visit[][];
	static int rgb_count[] = { 0, 0, 0 };
	static int rgb_count1[]={0,0};
	static int dx[] = { 0, 0, 1, -1 }, dy[] = { 1, -1, 0, 0 };
	static int rgb[] = { 82, 71, 66 };// R =82, G= 71,B=66;
	static int rgb_2[]= {82,66};

	public static void main(String[] ar) {
		String a;

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ad = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			a = sc.next();
			for (int j = 0; j < N; j++) {
				ad[i][j] = (int) a.charAt(j);
			}
		}
		for (int z = 0; z < rgb.length; z++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j])
						continue;
					if (ad[i][j] != rgb[z])
						continue;
					BFS(i, j, rgb[z], z,rgb_count);
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(ad[i][j] ==rgb[1])ad[i][j]=rgb[0];
			}
		}
		for(int i =0; i<N;i++){
			for(int j =0 ; j<N; j++){
				visit[i][j]=false;
			}
		}
		for (int z = 0; z < rgb_2.length; z++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j])
						continue;
					if (ad[i][j] != rgb_2[z])
						continue;
					BFS(i, j, rgb_2[z], z,rgb_count1);
				}
			}
		}


		for(int i : rgb_count1){
			ans1+=i;
		}
		for (int i : rgb_count)
			ans += i;
		System.out.println(ans+" "+ans1);
		sc.close();

	}

	public static void BFS(int x, int y, int color, int count,int r_count[]) {

		Queue<Point> q = new LinkedList<Point>();

		Point p = new Point(x, y);

		q.offer(p);
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int z = 0; z < size; z++) {
				p = q.poll();
				x = p.x;
				y = p.y;
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k], ny = y + dy[k];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (visit[nx][ny])
						continue;
					if (ad[nx][ny] != color)
						continue;
					visit[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
		r_count[count]++;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
