package com.dongjie;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    MinIntHeap minHeap = new MinIntHeap();
//
//	    Scanner in = new Scanner(System.in);
//
//	    while (in.hasNextInt()) {
//	        minHeap.add(in.nextInt());
//        }
//
//	    minHeap.printHeap();
//	    minHeap.heapSort();

		AdjList graph = new AdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
