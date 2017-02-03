package ex_1931;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 백준 1931 - 회의 시간을 고려한 회의장수의 최대 값을 구하는 문제
 * The problem to solve Max value about conference time 
 */

public class Main {
	public static void main(String[] args) {
		int N;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int count = 1;
		Time t[];
		t = new Time[N];

		for (int i = 0; i < N; i++) {
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			t[i] = new Time(t1, t2);
		}
		Arrays.sort(t,new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				if(o1.Finish>o2.Finish	)return 1;
				else if(o1.Finish == o2.Finish){
					if(o1.Start >o2.Start)
						return 1;
					else{
						return -1;
					}
				}
				else return -1;
			}
		});
	
		int max = t[0].Finish;

		for (int p = 1; p < N; p++) {
			if (max <= t[p].Start) {
				max = t[p].Finish;
				count++;
			}
		}
		System.out.println(count);
	}
}

class Time   {
	int Start, Finish;

	public Time(int start, int finish) {
		this.Start = start;
		this.Finish = finish;
	}


}