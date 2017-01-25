package ex_3047;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
	private static Scanner sc;
	private static int N[];
	private static String ABC;
	private static char ABC_C[];

	public static void main(String []ar){
		
		HashMap<Character, Integer> map =  new HashMap<Character, Integer>();
	
		sc = new Scanner(System.in);
		ABC_C = new char[3];
		
		N= new int[3];
		
		
		for (int i =0;i<3; i++){
			N[i]= sc.nextInt();
		}
		ABC= sc.next();
		
		ABC_C = ABC.toCharArray();
		
		for (int i = 0; i <3; i++){ // sorting
			for(int j=0; j<3; j++){
				if(N[i]<N[j]){
					int temp;
					temp = N[j];
					N[j]=N[i];
					N[i]=temp;
				}
			}
		}
	
		for(int i =0 ;i <3; i++){
			map.put((char)('A'+i), N[i]);
		}
		
		for(int i =0; i<ABC_C.length;i++){ // Ãâ·Â
			System.out.print(map.get(ABC_C[i])+" ");
		}
	}
}

