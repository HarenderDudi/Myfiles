package com.cs.sortingalgo;

import java.util.Arrays;

public class Heap {

	int capacity = 10;
	int size = 0;
	
	int[] items = new int[capacity];
	
	public static void main(String[] args) {
		
		Heap heap = new Heap();
		heap.add(3);
		heap.add(4);
		heap.add(6);
		heap.add(10);
		heap.add(2);
		
		for(int i = 0; i < heap.size ; i++){
			System.out.println(heap.items[i]);
		}
		
		heap.pop();
		
		System.out.println("-------------- UPDATED-------------");
		for(int i = 0; i < heap.size ; i++){
			System.out.println(heap.items[i]);
		}
		
	}
	
	private int getLeftChildIndex(int index){return index*2 + 1;}
	private int getRightChildIndex(int index){return index*2 + 2;}
	private int getParentIndex(int index){return (index - 1)/2;}
	
	private boolean hasLeftChild(int index){return getLeftChildIndex(index) < size;}
	private boolean hasRightChild(int index){return getRightChildIndex(index) < size;}
	private boolean hasParent(int index){return getParentIndex(index) >= 0;}
	
	private int getLeftChild(int index){return items[getLeftChildIndex(index)]; }
	private int getRightChild(int index){return items[getLeftChildIndex(index)]; }
	private int getParent(int index){return items[getParentIndex(index)]; }
	
	private void ensureCapacity(){
		if (size == capacity){
			items = Arrays.copyOf(items, capacity*2);
			capacity = capacity * 2;
		}
	}
	
	public void add(int item){
		ensureCapacity();
		items[size] = item;
		size++;
		
		heapifyUp();
	}
	
	private void heapifyUp(){
		int item = items[size-1];
		int index = size-1;
		while(hasParent(index) && getParent(index) > item){
			int parentIndex = getParentIndex(index);
			swap(parentIndex, index);
			index = getParentIndex(index);
		}
	}
	
	public int pop(){
		int item = items[0];
		items[0] = items[size-1];
		size--;
		
		heapifyDown();
		
		return item;
	}
	
	private void heapifyDown(){
		int index = 0;
		
		while(hasLeftChild(index)){
			int smallChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
				smallChildIndex = getRightChildIndex(index);
			}
			
			if(items[0] < items[smallChildIndex]){
				break;
			} else {
				swap(index, smallChildIndex);
			}
			index = smallChildIndex;
			
		}
		
	}

	private void swap(int parentIndex, int index) {
		int temp = items[index];
		items[index] = items[parentIndex];
		items[parentIndex] = temp;
	}

}
