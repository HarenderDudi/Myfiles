package com.cs.exams;

import java.util.ArrayList;

public class InfiniteGrid {

	public static void main(String[] args) {

		// A : [ 4, 8, -7, -5, -13, 9, -7, 8 ]
		// B : [ 4, -15, -10, -3, -13, 12, 8, -8 ]
		
		ArrayList<Integer> A = new ArrayList<>();
		A.add(4);
		A.add(8);
		A.add(-7);
		A.add(-5);
		A.add(-13);
		A.add(9);
		A.add(-7);
		A.add(8);
		
		ArrayList<Integer> B = new ArrayList<>();
		B.add(4);
		B.add(-15);
		B.add(-10);
		B.add(-3);
		B.add(-13);
		B.add(12);
		B.add(8);
		B.add(-8);
		
		System.out.println(coverPoints(A,B));
		
	}

	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

		Boolean isMoveForwordX = false;
		Boolean isMoveForwordY = false;
		int count = 0;

		int sizeA = A.size();
		int sizeB = B.size();

		if (sizeA < 2 || sizeB < 2) {
			// System.out.println("not proper input");
			return 0;
		}

		for (int i = 0; i < sizeA - 1; i++) {
			int startx = A.get(i);
			int starty = B.get(i);

			int endx = A.get(i + 1);
			int endy = B.get(i + 1);

			int disX = Math.abs(startx - endx);
			int disY = Math.abs(starty - endy);
			
			count += Math.max(disX, disY);
			
			/*// find direction

			int xDirForward = Math.abs((startx + 1) - endx);
			int xDirBackward = Math.abs((startx - 1) - endx);

			if (xDirForward < xDirBackward) {
				isMoveForwordX = true;
			}

			int yDirForward = (starty + 1) - endy;
			int yDirBackward = (starty - 1) - endy;

			if (yDirForward < yDirBackward) {
				isMoveForwordY = true;
			}

			while (currentX != endx || currentY != endy) {
				if (currentX != endx) {
					if (isMoveForwordX) {
						currentX++;
					} else {
						currentX--;
					}
				}

				if (currentY != endy) {
					if (isMoveForwordY) {
						currentY++;
					} else {
						currentY--;
					}
				}
				count++;
			}
*/
	}
		return count;
	}

}
