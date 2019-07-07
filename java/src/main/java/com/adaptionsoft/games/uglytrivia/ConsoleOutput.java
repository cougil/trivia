package com.adaptionsoft.games.uglytrivia;

public class ConsoleOutput implements GameOutput {
    @Override
    public void consoleWriteLine(String message) {
        System.out.println(message);
    }
}
