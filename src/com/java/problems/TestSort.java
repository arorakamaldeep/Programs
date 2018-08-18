package com.java.problems;

import java.util.*;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Employee emp1=new Employee(12, "Deep");
		Employee emp2=new Employee(11, "rock");
		Employee emp3=new Employee(10, "ana");*/
		Map<Integer, Employee> map=new HashMap();	
		map.put(1, new Employee(12, "Deep"));
		map.put(2, new Employee(11, "rock"));
		map.put(3, new Employee(10, "ana"));
		
		List<Employee> list = new ArrayList<Employee>(map.values());
		
		
		Collections.sort(list, new Employee());
		
		for(Employee ls: list)
			System.out.println(ls);
		
		for(Map.Entry m:map.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
			  }  

	}

}
