package ex_4963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int _row, _col, ad[][], count = 0;
	static boolean visit[][];

	public static void main(String[] ar) {

		Scanner sc = new Scanner(System.in);

		do {
			count = 0;

			_col = sc.nextInt();
			_row = sc.nextInt();
			ad = new int[_row][_col];
			visit = new boolean[_row][_col];

			for (int i = 0; i < _row; i++) {
				for (int j = 0; j < _col; j++) {
					ad[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < _row; i++) {
				for (int j = 0; j < _col; j++) {
					if (visit[i][j])
						continue;
					if (ad[i][j] != 1)
						continue;
					BFS(i, j);
				}
			}

			for (int i = 0; i < _row; i++) {
				for (int j = 0; j < _col; j++) {
					visit[i][j] = false;
				}
			}
			if (_row != 0 && _col != 0) {
				System.out.println(count);
			}

		} while (_row != 0 && _col != 0);

	}

	public static void BFS(int x, int y) {
		int dx[] = { 0, 0, 1, -1, -1, -1, 1, 1 }, dy[] = { 1, -1, 0, 0, 1, -1,
				1, -1 };// 아래,위 ,오른쪽,왼쪽 ,대각선

		Queue<Point> q = new LinkedList<Point>();

		Point p = new Point(x, y);

		q.offer(p);

		visit[x][y] = true;

		while (!q.isEmpty()) {
			int sz = q.size();
			for (int z = 0; z < sz; z++) {
				p = q.poll();
				int x1 = p.x, y1 = p.y;
				for (int k = 0; k < 8; k++) {
					int nx = x1 + dx[k], ny = y1 + dy[k];
					if (nx < 0 || ny < 0 || nx >= _row || ny >= _col)
						continue;
					if (visit[nx][ny])
						continue;
					if (ad[nx][ny] != 1)
						continue;
					visit[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}

			}
		}
		count++;

	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
