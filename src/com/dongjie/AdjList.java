package com.dongjie;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjList {

    private ArrayList<LinkedList<Integer>> adj = new ArrayList<>();

    public AdjList(int v) {
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    // This is undirected graph
    public void addEdge(int u, int v) {
       adj.get(u).add(v);
       adj.get(v).add(u);
    }

    public void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i);

            for (int j = 0; j < adj.get(i).size(); j ++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }

            System.out.println();
        }
    }
}
