package ex_2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int ad[][], N, max = 0, ans = 0;
	static boolean visit[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ad = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ad[i][j] = sc.nextInt();
				visit[i][j] = false;
			}
		}
		max = ad[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < ad[i][j])
					max = ad[i][j];
			}
		}
		max = max - 1;
		int temp = ans;

		do {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j])
						continue;
					if (ad[i][j] <= max) {
						continue;
					}

					BFS(i, j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit[i][j] = false;
				}
			}
			temp = D(ans, temp);
			max--;
			ans = 0;
		} while (max > 0);
		System.out.println(temp);

	}

	public static int D(int a, int b) {
		return a > b ? a : b;
	}

	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		int dx[] = { 0, 0, 1, -1 }, dy[] = { 1, -1, 0, 0 };

		Point p = new Point(x, y);
		q.offer(p);
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int sz = q.size();
			for (int z = 0; z < sz; z++) {
				p = q.poll();
				x = p.x;
				y = p.y;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i], ny = y + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (visit[nx][ny])
						continue;
					if (ad[nx][ny] <= max)
						continue;
					visit[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
		++ans;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
