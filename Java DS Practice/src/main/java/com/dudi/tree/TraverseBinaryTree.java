package com.dudi.tree;

import java.util.*;

public class TraverseBinaryTree {

	public static void main(String[] args) {
		int[] t = new int[] {10,5,6,1,2,3,9,7,8,4,0};
		
//		depthFirstTraverse(t, 0);
//		breadthFirstTraverse(t,0);
		
//		ArrayList<Integer> result = (ArrayList<Integer>) tracePath(t, 0, 2, 3);
//		for (Integer integer : result) {
//			System.out.print(t[integer] + "-->");
//		}
		
//		System.out.println(getMinByDepth(t, 0));
//		System.out.println("\t\t"+getMinByBreadth(t, 0));
		
		//System.out.println(getTreeSum(t, 0));
		
//		List<Integer> traverseLeftTree = traverseLeftTree(t, getLeftChildIndex(0));
//		List<Integer> traverseRightTree = traverseLeftTree(t, getRightChildIndex(0));
//		traverseLeftTree.add(0);
//		traverseLeftTree.addAll(traverseRightTree);
//		for (Integer integer : traverseLeftTree) {
//			System.out.print(t[integer]+"->");
//		}
		
//		int lca = lowestCommonAncestor(t, 0, 5,0);
//		System.out.println(t[lca]);
		
//		int distance = findDistanceBetweenNodes(t, 0, 7,9);
//		System.out.println(distance);
		
		List<Integer> traverseLeftTree = findPathBetweenNodes(t, 0, 7,9);
		for (Integer integer : traverseLeftTree) {
			System.out.print(t[integer]+"->");
		}
	}
	
	private static List<Integer> findPathBetweenNodes(int[] a, int root, int src, int dest) {

		int lca = lowestCommonAncestor(a,root, src, dest);
		
		List<Integer> result = new ArrayList<>();
		
		List<Integer> leftPath =  findPath(a,getLeftChildIndex(lca), src);
		List<Integer> rightPath =  findPath(a,getRightChildIndex(lca), dest);
		
		result.addAll(leftPath);
		result.add(lca);
		result.addAll(rightPath);
		
		return result;
	}
	
	private static List<Integer> findPath(int[] a, int root, int tgt) {
		List<Integer> result = new ArrayList<>();
		if(root >= a.length) {
			return result;
		}
		
		if(a[root] == tgt) {
			result.add(root);
			return result;
		}
		
		List<Integer> lp = findPath(a, getLeftChildIndex(root), tgt);
		List<Integer> rp = findPath(a, getRightChildIndex(root), tgt);
		
		if(lp.isEmpty() && rp.isEmpty()) {
			return result;
		}
		
		result.addAll(lp);
		result.add(root);
		result.addAll(rp);
		
		return result;
	}
	
	private static int findDistanceBetweenNodes(int[] a, int root, int src, int dest) {

		int lca = lowestCommonAncestor(a,root, src, dest);
		
		int leftDistance =  findDistance(a,getLeftChildIndex(lca), src);
		int rightDistance =  findDistance(a,getRightChildIndex(lca), dest);
		
		return leftDistance + rightDistance ;
	}
	
	private static int findDistance(int[] a, int root, int tgt) {
		if(root >= a.length) {
			return 0;
		}
		
		if(a[root] == tgt) {
			return 1;
		}
		
		int ld = findDistance(a, getLeftChildIndex(root), tgt);
		int rd = findDistance(a, getRightChildIndex(root), tgt);
		
		if(ld == 0 && rd == 0) {
			return 0;
		}
		
		return ld+rd+1;
	}
	
	private static int lowestCommonAncestor(int[] a, int root, int src, int dest) {
		
		if(root >= a.length) {
			return -1;
		}
		
		if(a[root] == src || a[root] == dest) {
			return root;
		}
		
		int foundInLeft = lowestCommonAncestor(a, getLeftChildIndex(root), src, dest);
		int foundInRight = lowestCommonAncestor(a, getRightChildIndex(root), src, dest);
		
		if(foundInLeft != -1 && foundInRight != -1) {
			return root;
		}
		
		return foundInLeft == -1 ? foundInRight : foundInLeft;
		
	}
	
	
	private static List<Integer> traverseLeftTree(int[] a, int root) {
		if(root >= a.length) {
			return new ArrayList<>();
		}
		List<Integer> traverseLeftTree = traverseLeftTree(a, getLeftChildIndex(root));
		List<Integer> traverseRightTree = traverseLeftTree(a, getRightChildIndex(root));
		traverseLeftTree.add(root);
		traverseLeftTree.addAll(traverseRightTree);
		return traverseLeftTree;
	}
	
	private static int getTreeSum(int[] a, int root) {
		
		if(root >= a.length) {
			return 0;
		}
		
		int leftSum = getTreeSum(a, getLeftChildIndex(root));
		int rightSum = getTreeSum(a, getRightChildIndex(root));
		
		return a[root] + leftSum + rightSum;
	}
	
	private static int getMinByDepth(int[] a, int root) {
		if(root >= a.length) {
			return Integer.MAX_VALUE;
		}
		
		int leftValue = getMinByDepth(a, getLeftChildIndex(root));
		int rightValue = getMinByDepth(a, getRightChildIndex(root));
		
		int min = Math.min(a[root], Math.min(leftValue, rightValue));
		
		return min;
	} 
	
	private static int getMinByBreadth(int[] a, int root) {
		
		Queue<Integer> q = new PriorityQueue<>();
		q.add(root);
		
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int r = q.poll();
			System.out.print(a[r]+"->");
			
			min = Math.min(min, a[r]);
			
			int leftChildIndex = getLeftChildIndex(r);
			if(leftChildIndex < a.length)
				q.add(leftChildIndex);
			
			int rightChildIndex = getRightChildIndex(r);
			if(rightChildIndex < a.length)
				q.add(rightChildIndex);
		}
		
		return min;
	}
	
	private static List<Integer> tracePath(int[] a, int root, int src, int dest) {
		
		if(root >= a.length)
			return new ArrayList<>();
		
		if(a[root] == src || a[root] == dest) 
			return Arrays.asList(root);
		
		List<Integer> leftResult = tracePath(a, getLeftChildIndex(root), src, dest);
		List<Integer> rightResult = tracePath(a, getRightChildIndex(root), src, dest);
		
		List<Integer> result = new ArrayList<>();
		if(!leftResult.isEmpty()) {
			result.addAll(leftResult);
			result.add(root);
		}
		
		
		if(!rightResult.isEmpty()) {
			result.addAll(rightResult);
			result.add(root);
		}
		
		return result;
	}
	
	private static void depthFirstTraverse(int[] a, int root) {
		
		if(root >= a.length) {
			return;
		}
		
		System.out.print(a[root] + " -> ");
		depthFirstTraverse(a, getLeftChildIndex(root));
		depthFirstTraverse(a, getRightChildIndex(root));
	}
	
	private static void breadthFirstTraverse(int[] a, int root) {

		Queue<Integer> q = new PriorityQueue<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int r = q.poll();
			System.out.print(a[r]+"->");
			
			int leftChildIndex = getLeftChildIndex(r);
			if(leftChildIndex < a.length)
				q.add(leftChildIndex);
			
			int rightChildIndex = getRightChildIndex(r);
			if(rightChildIndex < a.length)
				q.add(rightChildIndex);
		}
		
	}
	
	private static int getLeftChildIndex(int index){return index*2 + 1;}
	private static int getRightChildIndex(int index){return index*2 + 2;}
	private static int getParentIndex(int index){return (index - 1)/2;}

}
