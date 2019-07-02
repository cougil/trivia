package com.adaptionsoft.games.trivia.uglytrivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
}
