package omok;

import lombok.Getter;

@Getter
public class Player {
	String name;
	String stone;
	int winCount = 0;
	
	Player(String name, String stone) {
		this.name = name;
		this.stone = stone;
	}
	
	public void editConfig(String name, String stone) {
		this.name = name;
		this.stone = stone;
	}
	
	public void printPlayer() {
		System.out.println("name : " + name + " | stone : " + stone + " | winCount : " + winCount);
	}
	
	public void win() {
		++winCount;
	}
}
