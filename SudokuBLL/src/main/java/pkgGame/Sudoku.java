package pkgGame;

import ch.qos.logback.core.subst.Token.Type;
import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {

	private int size; // Length of the width/height.
	private int sqrtSize; //Square root of size.
	
	//Constructor given a size only.
	public Sudoku(int iSize) throws java.lang.Exception {
		try {
			if (iSize % Math.sqrt(iSize) != 0) {
				throw new java.lang.Exception("Invalid size, must have a whole numbered square root");
			}
		} catch (java.lang.Exception e) {
			System.out.println("Invalid size, must have a whole numbered square root");
		}
		this.size = iSize;
		this.sqrtSize = (int) Math.sqrt(iSize);	
	}
	
	//Constructor given a whole puzzle.
	public Sudoku(int[][] puzzle) throws java.lang.Exception {
		try {
			if (puzzle.length / Math.sqrt(puzzle.length) != Math.sqrt(puzzle.length)) {
				throw new java.lang.Exception("Invalid size, must have a whole numbered square root");
			}
		} catch (java.lang.Exception e) {
			System.out.println("Invalid size, must have a whole numbered square root");
		}
		
		this.size = puzzle.length;
		this.sqrtSize = (int) Math.sqrt(puzzle.length);
		super.setLatinSquare(puzzle);
	}
	
	//Returns the LatinSquare (aka Sudoku).
	public int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	
	//Passes in a given region and gets back a 
	//one-dimensional array of the region's content.
	
	public int[] getRegion(int region){
	    int regionRow = region / sqrtSize;
	    int regionColumn = region % sqrtSize;
	    int index = 0;
	    int[] output = new int[super.getLatinSquare().length];
	    for(int r=regionRow*sqrtSize; r<(regionRow+1)*sqrtSize; r++){
	        for(int c=regionColumn*sqrtSize; c<(regionColumn+1)*sqrtSize; c++){
	        	output[index] = super.getLatinSquare()[r][c];
	            index++;
	        }
	    }
	    return output;
	}
	
	
	//Figures out what region you're in based on iCol 
	//and iRow and calls getRegion to fetch the region as a 1-D array using above method.
	//[wouldn't let us name it getRegion (the same as above method)]
	//[sorry for the name change as a result]
	
	public int[] getRegionFromPoint(int col, int row){
	    int region = (row / sqrtSize) * sqrtSize + col / sqrtSize;
	    return getRegion(region);
	}
	
	
	// Returns true if:
	// isLatinSquare;
	// if each region doesn't have duplicates;
	// if each element in the first row is in each region;
	// at least one element is 0.
	public boolean isPartialSudoku() {
		if (super.isLatinSquare() == false) {
			return false;
			
		} else if (super.ContainsZero() == false) {
			return false;
			
		} else for (int r = 0; r > super.getLatinSquare().length; r++) {
			if (super.hasDuplicates(getRegion(r)) == true) {
				return false;
				
			} else if (super.hasAllValues(super.getRow(0), getRegion(r)) == false) {
				return false;
			}
		} return true;
		
	}
	
	// Returns true if:
	// isPartialSudoku();
	// no zeroes.
	public boolean isSudoku() {
		if (super.isLatinSquare() == false) {
			return false;
			
		} else if (super.ContainsZero() == true) {
			return false;
			
		} else for (int r = 0; r > super.getLatinSquare().length; r++) {
			if (super.hasDuplicates(getRegion(r)) == true) {
				return false;
				
			} else if (super.hasAllValues(super.getRow(0), getRegion(r)) == false) {
				return false;
			}
		} return true;
	}
	
	
	//Checks to see if element exists in a given row, column, and region, returning true if it doesn't
	//and false otherwise (true if valid, false if not).
	public boolean isValidValue(int iCol, int iRow, int iValue) {
		if (super.doesElementExist(this.getRegionFromPoint(iCol, iRow),iValue)) {
			return false;
		}
		
		if (super.doesElementExist(super.getColumn(iCol), iValue)) {
			return false;
		}
		
		if (super.doesElementExist(super.getRow(iRow), iValue)) {
			return false;
		}
		return true;
	}
}
