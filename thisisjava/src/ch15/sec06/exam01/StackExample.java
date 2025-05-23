package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(150));
		
		while (!coinBox.empty()) {
			var coin = coinBox.pop();
			System.out.println("pop : " + coin.getValue());
		}
		
	}

}
