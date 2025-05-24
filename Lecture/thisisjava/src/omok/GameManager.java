package omok;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
	
	private static GameManager gameManager = new GameManager();
	
	private GameManager() {
		System.out.println("Singleton constructor");
	}
	
	public static GameManager getInstance() {
		return gameManager;
	}
	
	List<Player> players = new ArrayList<Player>();
	Board board = null;
	int gameTurn = 0;
	Scanner scanner = new Scanner(System.in);
	
	public void play() {
		System.out.println("====================Game Play====================");
		
		while (true) {
			System.out.println("1.Set Player | 2.Set Board | 3.Play | 4.Show Result");
			System.out.print("input : ");
			String input = scanner.nextLine();
			
			switch (input) {
			case "1":
				setPlayer();
				break;
			case "2":
				setBoard();
				break;
			case "3":
				playGame();
				break;
			case "4":
				showResult();
				break;
			}
			
		}
		
	}
	
	private void setPlayer() {
		if (players.size() == 0) {
			while (true) {
				if (players.size()>=2) {
					System.out.print("Ready? (Y/N) : ");
					String str = scanner.nextLine();
					if ("Y".equals(str)) break;
				}
				System.out.print("User Name : ");
				String name = scanner.nextLine();
				System.out.print("User Symbol : ");
				String symbol = scanner.nextLine();
				players.add(new Player(name, symbol));
			}
		}
		else {
			System.out.print("1.Edit | 2.Add");
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				System.out.print("Player Name : ");
				String name = scanner.nextLine();
				Player target = null;
				for (var player : players) {
					if (player.name.equals(name)) {
						target = player;
						break;
					}
				}
				if (target == null) {
					System.out.println("No exist of player name : " + name);
				}
				else {
					System.out.print("User New Name : ");
					String newName = scanner.nextLine();
					System.out.print("User New Symbol : ");
					String newSymbol = scanner.nextLine();
					target.editConfig(newName, newSymbol);
				}
				System.out.println("Edit Done.");
				break;

			case "2":
				System.out.print("User Name : ");
				String newName = scanner.nextLine();
				System.out.print("User Symbol : ");
				String newSymbol = scanner.nextLine();
				players.add(new Player(newName, newSymbol));
				System.out.println("Add Done.");
				break;
			}
		}
		
	}
	
	private void setBoard() {
		if (board == null) {
			System.out.print("Board size : ");
			int size = Integer.parseInt(scanner.nextLine());
			board = new Board(size);
		}
		else {
			System.out.print("1.Change Size | 2.Done : ");
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				System.out.print("Size : ");
				int size = Integer.parseInt(scanner.nextLine());
				board.editBoard(size);
				break;
				
			case "2":
				break;
			}
		}
	}
	
	private void playGame() {
		int row = -1;
		int col = -1;
		gameTurn = -1;
		board.clearBoard();
		
		while (!checkBoard(row, col)) {
			++gameTurn;
			printInGame();
			
			board.print();
			try {
				// A 10 (열 행)
				System.out.print("입력 (열 행) : ");
				String input = scanner.nextLine();
				String sRow = input.split(" ")[1]; // 10
				String sCol = input.split(" ")[0]; // A
				
				col = (int)(sCol.charAt(0)-'A');
				row = Integer.parseInt(sRow);

				if (row<0 || row>=board.size || col<0 || col>=board.size) 
				{
					System.out.println("Invalid Coord");
					continue;
				}

				if (board.map[row][col].equals(".")) {
					board.map[row][col] = getCurrPlayer().getStone();
				}
				else {
					System.out.println("Invalid Coord.");
					continue;
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
				--gameTurn;
			}
			
		}
		showResult();
	}
	
	private void printInGame() {
		System.out.print("Turn : " + gameTurn + " | ");
		getCurrPlayer().printPlayer();
	}
	
	private Player getCurrPlayer() {
		return players.get(gameTurn % players.size());
	}
	
	private void showResult() {
		for (var player : players) {
			player.printPlayer();
		}
	}
	
	private boolean checkBoard(int row, int col) {
		System.out.println("Check " + row + "," + col);
		if (row == -1 || col == -1) return false;
		if (row<0 || row>=board.size || col<0 || col>=board.size) return false;

		boolean isOver = false;
		
		int[] dx = {0,-1,1};
		int len = dx.length;
		int len2 = len*len;
		int[][] dir = new int[len2][2];
		for (int i=0; i<len2; ++i) {
			dir[i] = new int[2];
			dir[i][0] = dx[i/len];
			dir[i][1] = dx[i%len];
		}
		
		// dir[0][0] == {0,0} pass
		String symbol = board.map[row][col];
		System.out.println("Current Symbol " + symbol);
		for (int i=1; i<len2; ++i) {
			int cnt = 1;
			int nr = row;
			int nc = col;
			for (int k=0; k<4; ++k) {
				nr += dir[i][0];
				nc += dir[i][1];
				
//				System.out.println(nr + "," + nc);
				
				if (nr<0 || nr>=board.size || nc<0 || nc>=board.size) continue;
				
				if (symbol.equals(board.map[nr][nc])) {
					++cnt;
				}
				else {
//					System.out.println();
					continue;
				}
			}
			
			if (cnt >= 5) {
				System.out.println("Count " + cnt + "row,col" + row + "," + col);
				isOver = true;
				board.print();
				System.out.println("================================");
				System.out.print("Winner : ");
				getCurrPlayer().printPlayer();
				getCurrPlayer().win();
				System.out.println("================================");
				break;
			}
		}
		
		return isOver;
	}

}
