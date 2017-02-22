package ex_2869;

import java.util.Scanner;

public class Main {
	
	static int A,B,V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0;
		
		A=sc.nextInt();
		B=sc.nextInt();
		V=sc.nextInt();
		while(true){
			V=V-A;
			count++;
			if(V<=0)break;
			V=V+B;
			
		}
		System.out.println(count);
		sc.close();
		
		
		
	}
}
