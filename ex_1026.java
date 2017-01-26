package ex_1026;

import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static int A[];
	private static int B[];

	private static int S;
	private static int N;

	public static void main(String []ar){

		sc= new Scanner(System.in);
		N = sc.nextInt();

		A= new int[N];
		B= new int[N];

		input(A);input(B);
		Sort(A,B);

		//func(A,B);


	}
	public static void input(int a[]){

		for (int i=0; i<a.length; i++){
			a[i]= sc.nextInt();
		}
	}
	public static void Sort(int a[],int b[]){
		for (int i =0;i<a.length;i++){
			for(int j =0; j<a.length;j++){
				if(a[i]>=a[j]){
					int temp;
					temp = a[j];
					a[j]=a[i];
					a[i]=temp;
				}
				if(b[i]<=b[j]){
					int tempb;
					tempb = b[j];
					b[j]=b[i];
					b[i]=tempb;
				}
			}
		}
		for ( int i = 0; i <a.length;i++){
			S += a[i]*b[i];
		}
		System.out.println(S);
		
	}
}

