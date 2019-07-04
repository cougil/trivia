package com.adaptionsoft.games.trivia.uglytrivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class GoldenMaster {
    public String getGameResult(long seed) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        GameRunner.play( new Random(seed) );

        return outputStream.toString();
    }

    public void generateGoldenMaster() throws IOException {
        for(long seed=0; seed<1000; seed++) {
            Path path = Paths.get (seed + ".txt");
            Files.write(path, getGameResult(seed).getBytes());
        }
    }
}
