package com.adaptionsoft.games.trivia.uglytrivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {

    private Game game;
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void setUp() {
		outputStream = getConsoleText();
		game = new Game();
	}

	@Test
	public void print_nothing_when_game_is_created() {
		String emptyString = "";

		assertEquals(emptyString, outputStream.toString());

	}

	@Test
	public void print_the_name_and_player_number_when_is_added() {
		String playerName = "john";

		game.add(playerName);

		String playerNameAndNumber = "john was added\n" +
				"They are player number 1\n";

		assertEquals(playerNameAndNumber, outputStream.toString());
	}

	@Test
	public void print_the_name_and_player_numbers_when_they_are_added() {
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
	public void do_something_when_rolling_dice() {

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

	/*@Test
	public void verify_trivia_against_golden_master() throws IOException, URISyntaxException {
		GoldenMaster goldenMaster = new GoldenMaster();
		for (long seed = 0; seed< MAX_SEED; seed++) {
			String expectedGameResult = goldenMaster.getGoldenMaster(seed);
			String actualGameResult = goldenMaster.getGameResult(seed);
			assertEquals(expectedGameResult, actualGameResult);
		}
	}*/

	@Test
	public void print_correct_answer_when_current_player_it_is_not_in_penalty_box() {

		game.add("John");

		outputStream = getConsoleText();

		game.wasCorrectlyAnswered();

		String expected = "Answer was correct!!!!\n" +
				"John now has 1 Gold Coins.\n";

		String actual = outputStream.toString();

		assertEquals(expected, actual);
	}

	private ByteArrayOutputStream getConsoleText() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		return outputStream;
	}

	@Test
	public void correct_answer_message_is_valid_because_of_bug() {
		String expected = "Answer was correct!!!!";

		String actual = game.getAnswerMessage();

		assertEquals(expected, actual);
	}

	@Test
	public void print_message_about_rolling_dice_and_player_location_when_cateogory_is_science() {

		game.add("SomePlayer");

		game.roll(4);

		assertEquals("SomePlayer was added\n" +
				"They are player number 1\n" +
				"SomePlayer is the current player\n" +
				"They have rolled a 4\n" +
				"SomePlayer's new location is 4\n" +
				"The category is Pop\n" +
				"Pop Question 0\n", outputStream.toString());
	}
}
