package com.wh.demo.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sort")
public class SortController {

	private int[] R = { 3, 8, 13, 4, 465, 9, 46, 62, 1, 102, 78 };

	@GetMapping("/quickly")
	public String quicklySort() {
		quicklySortMethod(R, 0, R.length - 1);
		printArray(R);
		return "SUCCESS";
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
		quicklySortMethod(N, lowTemp + 1, high);
		quicklySortMethod(N, 0, lowTemp - 1);
		

	}

	public void printArray(int[] r) {
		for (int i : r) {
			System.out.print(i + ",");
		}
		System.out.println("");
	}
}
