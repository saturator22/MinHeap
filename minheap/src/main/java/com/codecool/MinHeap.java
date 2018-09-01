package com.codecool;

public class MinHeap {
    private int cap = 100;
    private int size = 0;

    private int[] elements = new int[cap];

    private int getRightChildId(int parentId) {
        return 2 * parentId + 2;
    }

    private int getLeftChildId(int parentId) {
        return 2 * parentId + 1;
    }

    private int getParentId(int childId) {
        return (childId - 1)/2;
    }

    private boolean hasRightChild(int id) {
        return getRightChildId(id) < size;
    }

    private boolean hasLeftChild(int id) {
        return getLeftChildId(id) < size;
    }

    private boolean hasParent(int id) {
        return getParentId(id) >= 0;
    }

    private int getLeftChild(int id) {
        return elements[getLeftChildId(id)];
    }

    private int getRightChild(int id) {
        return elements[getRightChildId(id)];
    }

    private int getParent(int id) {
        return elements[getParentId(id)];
    }

    private void swap(int indexFirst, int indexSecond) {
        int temp = elements[indexSecond];
        elements[indexSecond] = elements[indexFirst];
        elements[indexFirst] = temp;
    }

    int peek() {
        if(size == 0) throw new IllegalStateException();
        return elements[0];
    }

    void heapifyDown() {
        int index = 0;

        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildId(index);

            if(hasRightChild(index) && getRightChildId(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildId(index);
            }

            if(elements[index] < elements[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    int poll() throws IllegalStateException{
        if (size == 0) throw new IllegalStateException();
        int element = elements[0];
        elements[0] = elements[size - 1];
        size--;
        heapifyDown();
        return element;
    }

    void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && getParent(index) > elements[index]) {
            swap(getParentId(index), index);
            index = getParentId(index);
        }
    }

    void add(int item) {
        elements[size] = item;
        size++;
        heapifyUp();
    }

    int getSize() {
        return size;
    }
}
