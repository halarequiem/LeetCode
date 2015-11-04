//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
//For example,
//
//Consider the following matrix:
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//Given target = 5, return true.
//
//Given target = 20, return false.
package _240_searchA2DMatrix_ii;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.searchMatrix(new int[][] { 
//				{ 1, 4, 7, 11, 15 }, 
//				{ 2, 5, 8, 12, 19 }, 
//				{ 3, 6, 9, 16, 22 },
//				{ 10, 13, 14, 17, 24 }, 
//				{ 18, 21, 23, 26, 30 } }, 20));
		System.out.println(s.searchMatrix(new int[][] { 
			{-5}}, -2));
	}

    public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (target == matrix[row][col])
				return true;

			if (target > matrix[row][col])
				row++;

			if (row < matrix.length && target < matrix[row][col])
				col--;
		}

		return false;
	}
}
