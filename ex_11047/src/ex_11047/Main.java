package ex_11047;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String []ar){
		int _coin, _input=0,ad[],p=0,count=0;
		
		Scanner sc = new Scanner(System.in);
		
		_coin = sc.nextInt();
		_input = sc.nextInt();
		ad = new int[_coin];
		
		for(int i=0; i<_coin; i++){
			ad[i]= sc.nextInt();
			
		}
		
		for(int i =0 ;i<_coin;i++){
			for(int j = i+1; j<_coin;j++){
				if(ad[i]<ad[j])
				{
					int temp;
					temp=ad[i];
					ad[i]=ad[j];
					ad[j]=temp;
				}
			}
		}
		while(_input!=0){
			
			if(ad[p] >_input)p++;
			else if(ad[p]<=_input){
				_input-=ad[p];
				count++;
			}
		}
		System.out.println(count);
	}
}
