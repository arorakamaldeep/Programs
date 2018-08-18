package com.java.multithreading;

import java.util.ArrayList;
import java.util.List;

public class MultitaskWithThreads {
	
	public static void main(String[] args) {
		
		List<Integer> list1= new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		
		List<Integer> list2= new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		
		Runnable task1= () -> {
			for(Integer ls: list1) 
			{
				System.out.println(ls);
				try {
						Thread.sleep(500);	
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		};
		
		Runnable task2= () -> {
			for(Integer ls: list2) 
			{
				System.out.println(ls);
				try {
					Thread.sleep(500);	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		
		t1.start();
		t2.start();
		
	}
	

}
