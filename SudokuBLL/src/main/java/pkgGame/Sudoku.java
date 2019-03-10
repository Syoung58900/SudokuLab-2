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

	public int[] getRegion(int i) {
		return null;
	}

	public int[] getRegion(int x, int y) {
		return null;
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
