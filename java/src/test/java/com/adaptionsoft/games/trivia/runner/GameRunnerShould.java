package com.adaptionsoft.games.trivia.runner;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameRunnerShould {

    @Test
    void print_specific_output_with_specific_seed() throws IOException {

        OutputStream outputStream = getConsoleOutput();

        GameRunner gameRunner = new GameRunnerForTest();
        gameRunner.run();

        assertEquals("Chet was added\n" +
                "They are player number 1\n" +
                "Pat was added\n" +
                "They are player number 2\n" +
                "Sue was added\n" +
                "They are player number 3\n" +
                "Chet is the current player\n" +
                "They have rolled a 3\n" +
                "Chet's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 0\n" +
                "Question was incorrectly answered\n" +
                "Chet was sent to the penalty box\n" +
                "Pat is the current player\n" +
                "They have rolled a 4\n" +
                "Pat's new location is 4\n" +
                "The category is Pop\n" +
                "Pop Question 0\n" +
                "Answer was correct!!!!\n" +
                "Pat now has 1 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 3\n" +
                "Sue's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 1\n" +
                "Answer was correct!!!!\n" +
                "Sue now has 1 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 2\n" +
                "Chet is not getting out of the penalty box\n" +
                "Pat is the current player\n" +
                "They have rolled a 3\n" +
                "Pat's new location is 7\n" +
                "The category is Rock\n" +
                "Rock Question 2\n" +
                "Answer was correct!!!!\n" +
                "Pat now has 2 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 3\n" +
                "Sue's new location is 6\n" +
                "The category is Sports\n" +
                "Sports Question 0\n" +
                "Answer was correct!!!!\n" +
                "Sue now has 2 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 3\n" +
                "Chet is getting out of the penalty box\n" +
                "Chet's new location is 6\n" +
                "The category is Sports\n" +
                "Sports Question 1\n" +
                "Answer was correct!!!!\n" +
                "Chet now has 1 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 3\n" +
                "Pat's new location is 10\n" +
                "The category is Sports\n" +
                "Sports Question 2\n" +
                "Answer was correct!!!!\n" +
                "Pat now has 3 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 5\n" +
                "Sue's new location is 11\n" +
                "The category is Rock\n" +
                "Rock Question 3\n" +
                "Answer was correct!!!!\n" +
                "Sue now has 3 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 3\n" +
                "Chet is getting out of the penalty box\n" +
                "Chet's new location is 9\n" +
                "The category is Science\n" +
                "Science Question 0\n" +
                "Answer was correct!!!!\n" +
                "Chet now has 2 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 1\n" +
                "Pat's new location is 11\n" +
                "The category is Rock\n" +
                "Rock Question 4\n" +
                "Answer was correct!!!!\n" +
                "Pat now has 4 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 3\n" +
                "Sue's new location is 2\n" +
                "The category is Sports\n" +
                "Sports Question 3\n" +
                "Answer was correct!!!!\n" +
                "Sue now has 4 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 5\n" +
                "Chet is getting out of the penalty box\n" +
                "Chet's new location is 2\n" +
                "The category is Sports\n" +
                "Sports Question 4\n" +
                "Answer was correct!!!!\n" +
                "Chet now has 3 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 4\n" +
                "Pat's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 5\n" +
                "Answer was correct!!!!\n" +
                "Pat now has 5 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 5\n" +
                "Sue's new location is 7\n" +
                "The category is Rock\n" +
                "Rock Question 6\n" +
                "Answer was correct!!!!\n" +
                "Sue now has 5 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 3\n" +
                "Chet is getting out of the penalty box\n" +
                "Chet's new location is 5\n" +
                "The category is Science\n" +
                "Science Question 1\n" +
                "Answer was correct!!!!\n" +
                "Chet now has 4 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 5\n" +
                "Pat's new location is 8\n" +
                "The category is Pop\n" +
                "Pop Question 1\n" +
                "Answer was correct!!!!\n" +
                "Pat now has 6 Gold Coins.\n", outputStream.toString());
    }

    private ByteArrayOutputStream getConsoleOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        return outputStream;
    }

}