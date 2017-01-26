package ex_2959;

import java.util.Scanner;

public class Main {
	public static int Sqaure[];
	public static Scanner sc;
	public static void main(String []ar ){
		sc=new Scanner(System.in);
		
		Sqaure=new int[4];
		for(int i =0; i<4;i++){
			Sqaure[i]=sc.nextInt();
			
		}
		for(int i =0; i<4; i++){
			for(int j=0;j<4;j++){
				if(Sqaure[i]<=Sqaure[j]){
					int temp;
					temp =Sqaure[j];
					Sqaure[j]=Sqaure[i];
					Sqaure[i]=temp;
					
				}
			}
		}
		System.out.println(Sqaure[0]*Sqaure[2]);
		
		
		
	}
}
