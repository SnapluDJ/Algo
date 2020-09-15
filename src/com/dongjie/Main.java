package com.dongjie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    MinIntHeap minHeap = new MinIntHeap();

	    Scanner in = new Scanner(System.in);

	    while (in.hasNextInt()) {
	        minHeap.add(in.nextInt());
        }

	    minHeap.printHeap();
	    minHeap.heapSort();
    }
}
