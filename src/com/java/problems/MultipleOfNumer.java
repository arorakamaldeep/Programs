package com.java.problems;

public class MultipleOfNumer {
	public static void ComplexityOrderOfSqureN(int n) {
		for(int i=1;i<n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i*j +" ");
			}
			System.out.println();
		}
	}
	public static void ComplexityOrderOfN(int n) {
		for(int i=1;i<n;i++) {
			
		}
	}
	public static void main(String[] args) {
		ComplexityOrderOfSqureN(5);
	}

}
