
package com.adaptionsoft.games.trivia.runner;
import com.adaptionsoft.games.uglytrivia.ConsoleOutput;
import com.adaptionsoft.games.uglytrivia.Game;

import java.io.IOException;
import java.util.Random;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) throws IOException {
		GameRunner gameRunner = new GameRunner();
		gameRunner.run();
	}

    private void run() throws IOException {
        run(getRandom());
    }

    protected Random getRandom() {
		return new Random();
	}

	public void run(Random rand) throws IOException {
		Game aGame = new Game(new ConsoleOutput());

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");


		do {

			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}



		} while (notAWinner);
	}
}
