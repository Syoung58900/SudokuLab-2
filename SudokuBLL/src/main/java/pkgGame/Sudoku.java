package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	
	public Sudoku() {
		super();
	}
	
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	
	protected int[][] getPuzzle(){
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int iRegionNbr) {
		int num_of_length;
		int start_row;
		int start_col;
		int count = 0;
		int iSize = getPuzzle().length;
		num_of_length = (int) Math.sqrt(iSize);
		int[] getRegion = new int[num_of_length * num_of_length];
		start_row = (iRegionNbr / num_of_length) * (iSize / num_of_length);
		start_col = (iRegionNbr % num_of_length) * (iSize / num_of_length);
		
		for (int i = start_row ; i < start_row + num_of_length  ; i++) {
			for (int k = start_col; k < start_col + num_of_length ; k++) {
				getRegion[count] = getPuzzle()[i][k];
				count = count + 1;
				}
		}
		return getRegion;
	}
	
	protected int[] getRegion(int Col, int Row){
		int iSize = getPuzzle().length;
		int iSqrtSize = (int) Math.sqrt(iSize);
		int i = (Row/ iSqrtSize) * iSqrtSize + (Col / iSqrtSize) ;
			
		return getRegion(i);
	}
	
	protected boolean isPartialSudoku() {
		boolean isPartialSudoku = false;
		int num_of_length;
		int iSize = getPuzzle().length;
		num_of_length = (int) Math.sqrt(iSize);
		int num_of_region = num_of_length* num_of_length;
		if(super.isLatinSquare()) {
			for (int i = 0; i< num_of_region; i++ ) {
				if (super.hasDuplicates(getRegion(i))) {
					return false;}
				else {
					isPartialSudoku = true;
				}
			}
		}else {
				return false;
		}
		
		if(super.doesElementExist(getRow(0), 0)) {
			isPartialSudoku = true;
			}
		else {
			return false;
			}
		
		return isPartialSudoku;
	}
	
	protected boolean isSudoku() {
		boolean isSudoku = false;
		if (isPartialSudoku()) {
			if(super.ContainsZero()) {
				return false;
			}else {
				isSudoku = true;
			}	
		}else {
			return false;
		}
		return isSudoku;
	}
	
	protected boolean isValueValid(int iValue, int Col, int Row) {
		boolean isValueValid = false;
		if(super.doesElementExist(super.getColumn(Col), iValue)) {
			return false;
		}else {
			if(super.doesElementExist(super.getRow(Row), iValue)) {
				return false;
			}else {
				if(super.doesElementExist(getRegion(Col,Row), iValue)) {
					return false;
				}else {
					isValueValid = true;
				}
			}
		}
		return isValueValid;
	}
}
