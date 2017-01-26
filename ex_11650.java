package ex_11650;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	static PriorityQueue<point> q= new PriorityQueue<point>(new SORT());
	
	private static Scanner sc;
	
	public static void main(String []ar){
		int N;
		point p;
		sc = new Scanner(System.in);
		N= sc.nextInt();
		
		for(int i=0;i<N;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			 p = new point(x,y);
			q.add(p);
		}
		for(int i = 0; i <N; i++){
			point pp = q.poll();
			System.out.print(pp.x+" "+pp.y+"\n");
		}
	}
}
class SORT implements Comparator<point>{

	public int compare(point p1, point p2) {
		if(p1.x<p2.x){ //x가 증가하는 순으로
			return -1;//upscending
		}
		else if(p1.x==p2.x){ //x가 같으면 
			if(p1.y<p2.y){//y가 증가하는 순으로
				return -1;
			}
			else{
				return 1;
			}
		}
		// TODO Auto-generated method stub
		else {
			return 1;
		}
	}
	
}

class point  {
	int x,y;

	public point(int x, int y) {
		this.x= x;
		this.y=y;

		// TODO Auto-generated constructor stub
	}
}
