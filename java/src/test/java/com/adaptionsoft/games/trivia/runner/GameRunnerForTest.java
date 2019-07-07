package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

public class GameRunnerForTest extends GameRunner {

    @Override
    protected Random getRandom() {
        return new Random();
    }

}
