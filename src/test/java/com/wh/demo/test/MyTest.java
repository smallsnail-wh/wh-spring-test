package com.wh.demo.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;

public class MyTest {
	int[] R = { 8, 3, 13, 4, 465, 9, 46, 62, 1, 102, 78 };
	int[] arrayTemp = { 8, 3, 13, 4, 465, 9, 46, 62, 1, 102, 78 };
	int[] r = { 1, 3, 4, 8, 9, 13, 46, 62, 78, 102, 465 };

	@Test
	public void guibinSrot() {
		fenMenthod(R, 0, R.length-1, arrayTemp);
		/* hebinmMethod(R,0,3,arrayTemp); */
		printArray(R);
	}

	public void fenMenthod(int[] array, int start, int end, int[] arrayTemp) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		fenMenthod(array, start, mid, arrayTemp);
		fenMenthod(array, mid + 1, end, arrayTemp);
		hebinmMethod(array, start, end, arrayTemp);
	}

	public void hebinmMethod(int[] array, int start, int end, int[] arrayTemp) {
		int mid = (start + end) / 2;
		int startTemp = start;
		int index = start;
		int midTemp = mid;
		while (startTemp <= mid && midTemp + 1 <= end) {
			if (array[startTemp] <= array[midTemp + 1]) {
				arrayTemp[index] = array[startTemp];
				startTemp++;
				index++;
			} else if (array[startTemp] > array[midTemp + 1]) {
				arrayTemp[index] = array[midTemp + 1];
				midTemp++;
				index++;
			}
		}
		while (startTemp <= mid) {
			arrayTemp[index] = array[startTemp];
			startTemp++;
			index++;
		}
		while (midTemp + 1 <= end) {
			arrayTemp[index] = array[midTemp + 1];
			midTemp++;
			index++;
		}
		for(int i = start;i<=end;i++) {
			array[i]=arrayTemp[i];
		}
	}

	@Test
	public void erfen() {
		int i = 4;
		int length = r.length;
		int start = 0;
		int end = length;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (i > r[mid]) {
				start = mid + 1;
			} else if (i < r[mid]) {
				end = mid - 1;
			} else if (i == r[mid]) {
				System.out.println(mid + 1);
				return;
			}
		}
		System.out.println("not exist");
	}

	@Test
	public void erfenSort() {
		int lenght = R.length;
		int low = 0;
		int high = 0;
		int mid = 0;
		int temp = 0;
		for (int i = 1; i < lenght; i++) {
			low = 0;
			high = i - 1;
			while (low <= high) {
				mid = (high + low) / 2;
				if (R[i] > R[mid]) {
					low = mid + 1;
				} else if (R[i] < R[mid]) {
					high = mid - 1;
				} else if (R[i] == R[mid]) {
					break;
				}
			}
			temp = R[i];
			for (int j = i - 1; j >= low; j--) {
				R[j + 1] = R[j];
			}
			R[low] = temp;
		}
		printArray(R);
	}

	@Test
	public void quicklySort() {
		quicklySortMethod(R, 0, 10);
		/* quickSort(R, 0, R.length - 1); */
		printArray(R);
	}

	public void quicklySortMethod(int[] N, int low, int high) {
		if (low >= high) {
			return;
		}
		int temp = N[low];
		int lowTemp = low;
		int highTemp = high;
		while (lowTemp < highTemp) {
			while (lowTemp < highTemp && N[highTemp] > temp) {
				highTemp--;
			}
			if (lowTemp < highTemp && N[highTemp] < temp) {
				N[lowTemp] = N[highTemp];
				lowTemp++;
			}
			while (lowTemp < highTemp && N[lowTemp] < temp) {
				lowTemp++;
			}
			if (lowTemp < highTemp && N[lowTemp] > temp) {
				N[highTemp] = N[lowTemp];
				highTemp--;
			}
		}
		N[lowTemp] = temp;
		System.out.println(high);
		quicklySortMethod(N, low, lowTemp - 1);
		quicklySortMethod(N, lowTemp + 1, high);
	}

	public void quickSort(int[] numbers, int start, int end) {
		if (start >= end) {
			return;
		}
		int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
		int temp; // 记录临时中间值
		int i = start, j = end;
		do {
			while ((numbers[i] < base) && (i < end))
				i++;
			while ((numbers[j] > base) && (j > start))
				j--;
			if (i <= j) {
				temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		/* if (start < j) */
		quickSort(numbers, start, j);
		/* if (end > i) */
		quickSort(numbers, i, end);
	}

	@Test
	public void bubbleSort() {
		int length = R.length;
		int temp;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (R[j] > R[j + 1]) {
					temp = R[j];
					R[j] = R[j + 1];
					R[j + 1] = temp;
				}
			}
		}
		printArray(R);
	}

	@Test
	public void selectSort() {
		int length = R.length;
		int temp;
		int index;
		for (int i = 0; i < length - 1; i++) {
			index = i;
			for (int j = i + 1; j < length; j++) {
				if (R[index] > R[j]) {
					index = j;
				}
			}
			if (index != i) {
				temp = R[i];
				R[i] = R[index];
				R[index] = temp;
			}
			System.out.println(index);
			printArray(R);
		}
	}

	@Test
	public void xierSort() {
		int group = R.length;
		int temp;
		while (group != 0) {
			group = group / 2;
			for (int i = 0; i < group; i++) {
				for (int k = i + group; k < R.length; k = k + group) {
					for (int j = k; j >= group; j = j - group) {
						if (R[j] < R[j - group]) {
							temp = R[j];
							R[j] = R[j - group];
							R[j - group] = temp;
						} else {
							break;
						}
					}
				}

			}
		}
		printArray(R);
	}

	@Test
	public void insertSort() {
		int length = R.length;
		int temp;
		for (int i = 1; i < length; i++) {
			for (int j = i; j >= 1; j--) {
				if (R[j] < R[j - 1]) {
					temp = R[j];
					R[j] = R[j - 1];
					R[j - 1] = temp;
				} else {
					break;
				}
			}
		}
	}

	public void printArray(int[] r) {
		for (int i : r) {
			System.out.print(i + ",");
		}
		System.out.println("");
	}

	@Test
	public void binarySearch() {
		int r = 55;
		int[] R = { 1, 3, 4, 8, 9, 13, 46, 78, 62, 102, 465 };
		int start = 0;
		int end = R.length - 1;
		int min = end / 2;
		while (end >= start) {
			if (R[min] > r) {
				end = min - 1;
				min = (end + start) / 2;
			} else if (R[min] < r) {
				start = min + 1;
				min = (end + start) / 2;
			} else if (R[min] == r) {
				System.out.print(min + 1);
				return;
			}
		}
		System.out.print(-1);
	}

	private int count;

	@Test
	public void maopaoSort() {
		int[] R = { 12, 5, 16, 19, 14, 9, 6, 6 };
		int temp;

		for (int i = 0; i < R.length - 1; i++) {
			for (int j = 0; j < R.length - i - 1; j++) {
				if (R[j] < R[j + 1]) {
					temp = R[j];
					R[j] = R[j + 1];
					R[j + 1] = temp;
				}
			}
		}
		for (int i : R) {
			System.out.print(i + " ");
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
