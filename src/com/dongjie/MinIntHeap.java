package com.dongjie;

import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 1;
    private int size = 0;

    private int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex -1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();

        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();

        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int currentIndex = size -1;

        while (hasParent(currentIndex) && items[currentIndex] < parent(currentIndex)) {
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public void heapifyDown() {
        int currentIndex = 0;

        while(hasLeftChild(currentIndex)) {
            int smallerChildIndex = getLeftChildIndex(currentIndex);

            if (hasRightChild(currentIndex) && rightChild(currentIndex) < leftChild(currentIndex)) {
                smallerChildIndex = getRightChildIndex(currentIndex);
            }

            if (items[currentIndex] > items[smallerChildIndex]) {
                swap(currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
            } else {
                return;
            }
        }
    }

    public void printHeap() {
        System.out.println(Arrays.toString(items));
    }

    public void heapSort() {
        while (size > 0) {
            System.out.print(poll() + "  ");
        }
    }
}
