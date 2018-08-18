package com.java.problems;

public class SearchClosestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,5,8,10};
		int n= arr.length - 1;
		int closeElement=0;
		int srch1=3;
		int srch2=3;
		
		while(srch1 >= arr[0] && srch2 <= arr[n]) 
		{
			int first=0;
			int last=n;
			int mid=first+last/2;
			
			int first2=0;
			int last2=n;
			int mid2=first+last/2;
			
			while((first <= last || first2 <= last2)  && (arr[mid]!=srch1 || arr[mid2]!=srch2)) 
			{
				if(srch1 < arr[mid]){
					last=mid-1;
				}
				else {
					first=mid+1;
				}
				mid=(first+last)/2;
				
				if(srch2 < arr[mid2]){
					last2=mid2-1;
				}
				else {
					first2=mid2+1;
				}
				mid2=(first2+last2)/2;
			}
			
			if(arr[mid] == srch1) {
				closeElement=srch1;
				break;
			}
			else if(arr[mid2] == srch2) {
				closeElement=srch2;
				break;
			}
			else {
				srch1--;
				srch2++;
			}
		}
		System.out.println("Closest element-:" + closeElement);
	}

}
