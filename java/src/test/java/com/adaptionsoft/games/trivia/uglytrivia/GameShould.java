package com.adaptionsoft.games.trivia.uglytrivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameShould {

	@Test
	public void print_nothing_when_game_is_created() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		String emptyString = "";

		Game game = new Game();

		assertEquals(emptyString, outputStream.toString());

	}
}
