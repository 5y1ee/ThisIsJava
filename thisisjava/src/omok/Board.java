package omok;

public class Board {
	
	int size;
	String[][] map;
	
	// Constructor
	Board(int size) {
		editBoard(size);
	}
	
	public void print() {
		int digitCount = String.valueOf(Math.abs(size)).length();
		for (int row=0; row<size; ++row) {
			// 행좌표
//			System.out.printf("%*d", digitCount, row);
			System.out.printf("%" + digitCount + "d", row);
			for (int col=0; col<size; ++col) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}
		// 열좌표
		System.out.print(" ".repeat(digitCount));
		for (int i=0; i<size; ++i) {
			System.out.print(" "+(char)('A'+i));
		}
		System.out.println();
	}
	
	public void editBoard(int size) {
		this.size = size;
		map = new String[size][size];
		clearBoard();
		System.out.println("Board Set by size " + size);
	}
	
	public void clearBoard() {
		for (int row=0; row<size; ++row) {
			for (int col=0; col<size; ++col) {
				map[row][col]=".";
			}
		}
		
	}
	
	
}
