package com.java.problems;

interface a{
	public void help();
}
interface b extends a{
	public void help();
}
interface c extends b{
	public void help();
}
public class ProblemPrractice implements c {

	@Override
	public void help() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
	}
	public static void main(String[] args) {
		//new ProblemPrractice().help();
		int arr[] = new int [5];
	    System.out.print(arr[1]);
	    int x=0;
	    x =+ 1;
	    System.out.println(x);
	    	}

}
