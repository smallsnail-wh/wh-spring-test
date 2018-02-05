package com.wh.demo.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;

public class MyTest {

	private int count;

	@Test
	public void maopaoSort() {
		int[] R = {12,5,16,19,14,9,6,6};
		int temp;
		
		
		
		for(int i = 0;i < R.length-1;i++) {
			for(int j = 0;j<R.length-i-1;j++) {
				if(R[j]<R[j+1]) {
					temp = R[j];
					R[j] = R[j+1];
					R[j+1] = temp;
				}
			}
		}
		for(int i : R) {
			System.out.print(i+" ");
		}
	}
	
	@Test
	public void mapTest() {
		new Hashtable();
		new HashMap();
		List<String> vector = new Vector<String>();
		vector.add("c");
		vector.add("a");
		vector.add("a");
		vector.add("b");
		System.out.println(vector);
		
		Set<String> set = new TreeSet<String>();
		set.addAll(vector);
		set.add("e");
		set.add("d");
		System.out.println(set);
		
	}

	@Test
	public void StringTest() {
		StringBuffer builder = new StringBuffer();
		System.out.println(builder.hashCode());
		builder.append("ab");
		System.out.println(builder);
		builder.append("cd");
		System.out.println(builder.hashCode());
	}

	@Test
	public void equalsAndHashCodeTest() {
		Object object = new Object();
		object.hashCode();
		CalssTest calssTest = new CalssTest();
		CalssTest calssTest2 = new CalssTest();
		System.out.println(calssTest.hashCode());
		System.out.println(calssTest2.hashCode());
	}

	class CalssTest {
		private int i;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
	}

	@Test
	public void equalsTest() {
		Integer b1 = new Integer(1);
		Integer b2 = b1;
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));
	}

	@Test
	public void switchTest() {
		String s = "as";

		switch (s) {
		case "a":
			System.out.println("a");
			break;
		case "b":
			System.out.println("b");
			break;
		default:
			System.out.println("c");
		}
	}

}
