package com.adaptionsoft.games.trivia.uglytrivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

import static com.adaptionsoft.games.trivia.uglytrivia.GoldenMaster.MAX_SEED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameShould {

    private Game game;
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	void setUp() {
		outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		game = new Game();
	}

	@Test
	public void print_nothing_when_game_is_created() {
		String emptyString = "";

		assertEquals(emptyString, outputStream.toString());

	}

	@Test
	void print_the_name_and_player_number_when_is_added() {
		String playerName = "john";

		game.add(playerName);

		String playerNameAndNumber = "john was added\n" +
				"They are player number 1\n";

		assertEquals(playerNameAndNumber, outputStream.toString());
	}

	@Test
	void print_the_name_and_player_numbers_when_they_are_added() {
		String firstPlayerName = "john";
		String secondPlayerName = "mike";

		game.add(firstPlayerName);
		game.add(secondPlayerName);

		String firstPlayerNameAndNumber = "john was added\n" +
				"They are player number 1\n";
		String secondPlayerNameAndNumber = "mike was added\n" +
				"They are player number 2\n";

		assertEquals(firstPlayerNameAndNumber+secondPlayerNameAndNumber, outputStream.toString());
	}

	@Test
	void do_something_when_rolling_dice() {

		game.add("SomePlayer");

		game.roll(1);

		assertEquals("SomePlayer was added\n" +
				"They are player number 1\n" +
				"SomePlayer is the current player\n" +
				"They have rolled a 1\n" +
				"SomePlayer's new location is 1\n" +
				"The category is Science\n" +
				"Science Question 0\n", outputStream.toString());
	}

	@Test
	void verify_trivia_against_golden_master() throws IOException, URISyntaxException {
		GoldenMaster goldenMaster = new GoldenMaster();
		for (long seed = 0; seed< MAX_SEED; seed++) {
			String expectedGameResult = goldenMaster.getGoldenMaster(seed);
			String actualGameResult = goldenMaster.getGameResult(seed);
			assertEquals(expectedGameResult, actualGameResult);
		}
	}

	@Test
	void print_correct_answer_when_current_player_it_is_not_in_penalty_box() {

		game.add("John");

		game.wasCorrectlyAnswered();

		assertEquals("John was added\n" +
				"They are player number 1\n" +
				"Answer was corrent!!!!\n" +
				"John now has 1 Gold Coins.\n", outputStream.toString());
	}
}
