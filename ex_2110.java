package ex_2110;

import java.util.Scanner;

public class Main {
	public static int Home_count;
	public static int Share_count;
	public static Scanner sc;
	public static int Home_Arr[];

	public static void main(String []ar){

		sc = new Scanner(System.in);

		Home_count = sc.nextInt();

		Share_count= sc.nextInt();

		Home_Arr=new int[Home_count];
		Create_Array(Home_Arr);
		sort(Home_Arr);
		binarySearch(Home_Arr);
	}
	public static void Create_Array(int arr[]){
		for(int i = 0; i<arr.length; i++){
			arr[i]=sc.nextInt();
		}

	}
	public static boolean check(int [] v ,int mid, int k){

	    int cnt = 1;
	    int start = v[0];

	    for(int i =1;i<v.length;++i){
	        if(v[i] - start >= mid){
	            cnt++;
	            start = v[i];
	        }
	    }

	    return cnt >= k;
	}
	public static void sort(int arr[]){
		int temp=0;
		for(int i =0;i<arr.length;i++){
			for(int j =0;j<arr.length;j++){
				if(arr[i]<arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
	}
	public static void binarySearch(int []v){
		 int start = 1;
		    int end = v[Home_count-1] - v[0];

		    int ans = start;
		    while(start<=end){
		        int mid = (start + end)/2;

		        if(check(v,mid,Share_count)){
		            if( ans < mid){
		                ans = mid;
		            }
		            start = mid + 1;
		        } else {
		            end = mid -1;
		        }
		    }
		    System.out.println(ans);
	}
}
