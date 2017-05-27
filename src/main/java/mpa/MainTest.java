package mpa;

import java.util.Arrays;
import java.util.List;

public class MainTest {
	

	public static void main(String[] args) {
		App app = new App();

		List<String> msgs = Arrays.asList("apple at 10p", "apple at 5p", "orange at 15p", "banana at 10p",
				"orange at 10p", "banana at 10p", "add 1p apples", "subtract 1p bananas", "apple at 10p",
				"orange at 2p", "banana at 3p", "banana at 6p", "apple at 1p", "20 sales of apples at 1p each",
				"10 sales of bananas at 2p each", "30 sales of oranges at 3p each", "multiply 2p oranges",
				"banana at 10p", "add 1p apples", "subtract 1p bananas", "apple at 10p", "apple at 10p", "apple at 5p",
				"orange at 15p", "banana at 10p", "orange at 10p", "banana at 10p", "add 1p apples",
				"add 1p bananas", "apple at 10p", "orange at 2p", "banana at 3p", "banana at 6p", "apple at 1p",
				"20 sales of apples at 1p each", "10 sales of bananas at 2p each", "30 sales of oranges at 3p each",
				"multiply 2p oranges", "banana at 10p", "add 1p apples", "subtract 1p bananas", "apple at 10p",
				"apple at 10p", "apple at 5p", "orange at 15p", "banana at 10p", "orange at 10p", "banana at 10p",
				"5 sales of apples at 2p each", "7 sales of bananas at 9p each", "6 sales of oranges at 13p each"
				);

		app.processMsgs(msgs);
	}

}
