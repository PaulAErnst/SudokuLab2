package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgHelper.LatinSquare;

public class SudokuTest extends LatinSquare {

	@Test
	public void getRegion_Test1() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {3, 4, 1, 2} , {2, 1, 4, 3} , {4, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		int[] arr1 = Sud.getRegion(0);
		int[] arr2 = {1, 2, 3, 4};
		assertArrayEquals(arr1, arr2);
		
	}
	
	@Test
	public void getRegion_Test2() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {3, 4, 1, 2} , {2, 1, 4, 3} , {4, 3, 2, 1} };
		Sudoku Sud = new Sudoku(arr);
		int[] arr1 = Sud.getRegion(2);
		int[] arr2 = {2, 1, 4, 3};
		//System.out.println(arr1[0]);
		//System.out.println(arr2[0]);
		assertArrayEquals (arr2, arr1);
		
	}
	
	@Test
	public void getRegionFromPoint_Test1() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {3, 4, 1, 2} , {2, 1, 4, 3} , {4, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		int[] arr1 = Sud.getRegionFromPoint(2, 3);
		int[] arr2 = {4, 3, 1, 2};
		
		
		assertArrayEquals(arr1, arr2);
	}
	
	@Test
	public void getRegionFromPoint_Test2() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {3, 4, 1, 2} , {2, 1, 4, 3} , {4, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		int[] arr1 = Sud.getRegionFromPoint(0, 2);
		int[] arr2 = {2, 1, 4, 3};
		
		assertArrayEquals (arr1, arr2);
	}
	
	@Test
	public void isSudoku_Test1() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {3, 4, 1, 2} , {2, 1, 4, 3} , {4, 3, 2, 1} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isS = Sud.isSudoku();
		assertTrue(isS);
	}
	
	@Test
	public void isSudoku_Test2() throws java.lang.Exception {
		int[][] arr = { {1, 0, 3, 4} , {3, 4, 1, 2} , {2, 1, 4, 3} , {4, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isS = Sud.isSudoku();
		
		assertFalse(isS);
	}
	
	@Test
	public void isSudoku_Test3() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {1, 4, 3, 2} , {2, 1, 4, 3} , {4, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isS = Sud.isSudoku();
		
		assertFalse(isS);
		
	}
	
	@Test
	public void isSudoku_Test4() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {3, 5, 1, 2} , {2, 1, 5, 3} , {5, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isS = Sud.isSudoku();
		
		assertFalse(isS);
	}
	
	@Test
	public void isPartialSudoku_Test1() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 0} , {3, 0, 1, 2} , {2, 1, 0, 3} , {0, 3, 2, 1} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isS = Sud.isPartialSudoku();
		
		assertTrue(isS);
	}
	
	@Test
	public void isPartialSudoku_Test2() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 4} , {3, 4, 1, 2} , {2, 1, 4, 3} , {4, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isS = Sud.isPartialSudoku();
		
		assertFalse(isS);
	}
	
	@Test
	public void isValueValid_Test1() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 0} , {3, 0, 1, 2} , {2, 1, 0, 3} , {0, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isVV = Sud.isValidValue(3, 0, 4);
		
		assertTrue(isVV);
		
	}
	
	@Test
	public void isValueValid_Test2() throws java.lang.Exception {
		int[][] arr = { {1, 2, 3, 0} , {3, 0, 1, 2} , {2, 1, 0, 3} , {0, 3, 1, 2} };
		Sudoku Sud = new Sudoku(arr);
		
		boolean isVV = Sud.isValidValue(0, 3, 1);
		
		assertFalse(isVV);
	}
}
	


