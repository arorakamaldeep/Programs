package com.java.problems;

public class Searching {
	
	public static int linearSearch(int[] arr, int num) {
		  for(int i=0;i<arr.length; i++) {
			  if(arr[i]==num) {
				  return i;
			  }
		  }
		return -1;
	}
	
	public static int binarySearch(int[] arr,int num) {
		int last=arr.length-1;
		int first=0;
		int mid=(first+last)/2;
		while(first <= last) {
			if(arr[mid]==num) {
				return mid;
			}
			else if(num < arr[mid]){
				last=mid-1;
			}
			else {
				first=mid+1;
			}
			mid=(first+last)/2;
		}
		return mid;
	}
	public static void main(String[] args) {
		int[] arr= {12,23,11,8,3,2,50,32,44,67,98};
		int[] arr1= {2,3,11,33,44,55,60,61,65,73,88};
		int search=44;
		System.out.println("Element on position-:" + linearSearch(arr,search));
		System.out.println("Element on position-:" + binarySearch(arr1,search));
	}

}
