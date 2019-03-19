package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {
	@Test
	public void getRegion_test1() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		s.setLatinSquare(LatinSquare);
		int[] ExpectedRegion = {3,4,4,1};
		int[] Region = s.getRegion(2);
		assertTrue(Arrays.equals(ExpectedRegion, Region));
		System.out.println(Arrays.toString(Region));
	}
	
	@Test
	public void getRegion_test2() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		s.setLatinSquare(LatinSquare);
		int[] ExpectedRegion = {1,2,3,2};
		int[] Region = s.getRegion(0);
		assertFalse(Arrays.equals(ExpectedRegion, Region));
		System.out.println(Arrays.toString(Region));
	}
	
	@Test
	public void getRegion_test3() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		s.setLatinSquare(LatinSquare);
		int[] ExpectedRegion = {2,3,3,4};
		int[] Region = s.getRegion(3, 0);
		assertTrue(Arrays.equals(ExpectedRegion, Region));
		System.out.println(Arrays.toString(Region));
	}
	
	@Test
	public void getRegion_test4() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		s.setLatinSquare(LatinSquare);
		int[] ExpectedRegion = {1,2,3,2};
		int[] Region = s.getRegion(0, 0);
		assertFalse(Arrays.equals(ExpectedRegion, Region));
		System.out.println(Arrays.toString(Region));
	}
	
	@Test
	public void isPartialSudoku_test1() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		s.setLatinSquare(LatinSquare);
		boolean aisPartialSudoku = s.isPartialSudoku();
		assertEquals(aisPartialSudoku, false);
	}
	
	@Test
	public void isPartialSudoku_test2() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{3,1,4,2},{2,4,1,3},{4,3,2,1},{1,2,3,4}};
		s.setLatinSquare(LatinSquare);
		boolean aisPartialSudoku = s.isPartialSudoku();
		assertEquals(aisPartialSudoku, false);
	}
	
	@Test
	public void isPartialSudoku_test3() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{2,0,3,1},{1,3,0,2},{3,2,1,0},{0,1,2,3}};
		s.setLatinSquare(LatinSquare);
		boolean aisPartialSudoku = s.isPartialSudoku();
		assertEquals(aisPartialSudoku, true);
	}
	
	@Test
	public void isPartialSudoku_test4() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{2,0,3,0},{0,3,0,2},{3,2,0,0},{0,0,2,3}};
		s.setLatinSquare(LatinSquare);
		boolean aisPartialSudoku = s.isPartialSudoku();
		assertEquals(aisPartialSudoku, false);
	}
	
	@Test
	public void isSudoku_test1() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{2,0,3,0},{0,3,0,2},{3,2,0,0},{0,0,2,3}};
		s.setLatinSquare(LatinSquare);
		boolean aisPartialSudoku = s.isPartialSudoku();
		assertEquals(aisPartialSudoku, false);
	}
	
	@Test
	public void isValueValid_test1() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		s.setLatinSquare(LatinSquare);
		boolean aisValueValid = s.isValueValid(2, 3, 0);
		assertEquals(aisValueValid, false);
	}
	
	@Test
	public void isValueValid_test2() {
		Sudoku s = new Sudoku();
		int[][] LatinSquare = {{0,1,2,3},{1,2,3,4},{3,4,1,2},{4,1,3,2}};
		s.setLatinSquare(LatinSquare);
		boolean bisValueValid = s.isValueValid(5, 3, 0);
		assertEquals(bisValueValid, true);
	}
}