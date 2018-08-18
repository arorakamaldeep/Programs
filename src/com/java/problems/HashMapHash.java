package com.java.problems;

import java.util.*;

public class HashMapHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		hm.put(2, 3);
		hm.put(2, 4);
		hm.put(2, 3);
		System.out.println(hm);
		for(Map.Entry m:hm.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue() + " " + m.hashCode());  
		}  
		
	}

}
