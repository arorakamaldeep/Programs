package com.java.problems;

public class OccuranceOfNumer {
	
	public static void findOddOccurenace(int[] a, int size) {
		int res=0;
		for(int i=0;i<size;i++) {
			res ^=a[i];
		}
		System.out.println("Occurance of number odd times" + res);
	}
	public static void multiple(int num) {
		System.out.println(num << 1);
	}
	public static void division(int num) {
		System.out.println(num >> 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{12, 12, 14, 90, 14, 14, 14};
		int n=arr.length;
		findOddOccurenace(arr,n);
		multiple(arr[0]);
		division(arr[0]);
	}

}
