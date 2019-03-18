package pkgGame;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	int iSize;
	int iSqrtSize;

	public Sudoku() {
		super();

	}

	public Sudoku(int[][] puzzle) {
		super(puzzle);

	}

	public int[][] getPuzzle() {
		return null;
	}
	
	public int[] getRegion(int iRow, int iCol) throws Exception {
		int[][] puzzle = this.getPuzzle();
		if (iCol >=iSize || iRow >= iSize) {
			throw new Exception("Region Index Out of Bounds");
		}
		else {
			int iSize = puzzle.length;
			int iSizeSqrt = (int) Math.sqrt(iSize);
			int i = (iCol/iSizeSqrt) + ((iRow/iSizeSqrt)*iSizeSqrt);
			return getRegion(i);
		}
	}
	
	protected int[] getRegion(int iReg) throws Exception {
		int[][] puzzle = this.getPuzzle();
		int[] region = new int[puzzle.length];
		int index = 0;
		int iSize = puzzle.length;
		int iSizeSqrt = (int) Math.sqrt(iSize);
		if(iReg >= iSize)
			throw new Exception ("Region Index Out of Bounds");
		for (int iRow = (iReg/iSizeSqrt)* iSizeSqrt; iRow < (((iReg/iSize) +1)*iSizeSqrt); iRow ++){
			for(int iCol = (iReg % iSizeSqrt)* iSizeSqrt; iCol < (((iReg % iSizeSqrt)+1)*iSizeSqrt); iCol++) {
				region[index++] = puzzle[iRow][iCol];
			}
		}
		return region;
	}

	public boolean hasDuplicates(){
		boolean hasDuplicates = false;
		if(super.hasDuplicates()) {
			return true;
		}
		for(int i = 0; i< this.getLatinSquare().length;i++) {
				if(hasDuplicates(this.getRegion(i))) {
					hasDuplicates = true;
				}
		}
		return hasDuplicates;
	}


	public boolean isSoduku() {
		return false;
	}

	public boolean isParitalSoduku() {
		return false;
	}

	public boolean isValidValue(int x, int y, int z) {
		return false;
	}

}
