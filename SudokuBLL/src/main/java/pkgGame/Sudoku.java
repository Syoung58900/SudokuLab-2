package pkgGame;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	int iSize;
	int iSqrtSize;

	public Sudoku(int iSize) throws Exception {
		super();
		this.iSize = iSize;
		if (Math.sqrt(iSize) == (int) Math.sqrt(iSize))
			this.iSqrtSize = (int) Math.sqrt(iSize);
		else
			throw new Exception("Size does not have integer square root");
	}

	public Sudoku(int[][] puzzle) throws Exception {
		super(puzzle);

		iSize = puzzle.length;

		if (Math.sqrt(iSize) == (int) Math.sqrt(iSize))
			this.iSqrtSize = (int) Math.sqrt(iSize);
		else
			throw new Exception("Size does not have integer square root");

	}

	public int[][] getPuzzle() {
		return super.getLatinSquare();
	}

	public int[] getRegion(int iRow, int iCol) {
		int i = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);
		return getRegion(i);
	}

	public int[] getRegion(int iReg) {
		int[][] puzzle = this.getPuzzle();
		int[] region = new int[puzzle.length];
		int index = 0;
		for (int iRow = (iReg / iSqrtSize) * iSqrtSize; iRow < (((iReg / iSize) + 1) * iSqrtSize); iRow++) {
			for (int iCol = (iReg % iSqrtSize) * iSqrtSize; iCol < (((iReg % iSqrtSize) + 1) * iSqrtSize); iCol++) {
				region[index++] = puzzle[iRow][iCol];
			}
		}
		return region;
	}

	public boolean hasDuplicates() {
		boolean hasDuplicates = false;
		if (super.hasDuplicates(null)) {
			return true;
		}
		for (int i = 0; i < this.getLatinSquare().length; i++) {
			if (hasDuplicates(this.getRegion(i))) {
					hasDuplicates = true;
			}
		}
		return hasDuplicates;
	}

	public boolean isSoduku() {

		if (!isParitalSoduku())
			return false;

		if (super.ContainsZero())
			return false;

		return true;
	}

	public boolean isParitalSoduku() {
		for (int i = 0; i < this.iSize; i++) {
			if (super.hasDuplicates(getRegion(i))) {
				return false;
			}
		}

		if (!super.isLatinSquare()) {
			return false;
		}

		return false;
	}

	public boolean isValidValue(int iCol, int iRow, int iValue) {
		if (doesElementExist(super.getRow(iRow), iValue))
			return false;
		else if (doesElementExist(super.getColumn(iCol), iValue))
			return false;
		else if (doesElementExist(getRegion(iRow, iCol), iValue))
			return false;

		return true;

	}

}

