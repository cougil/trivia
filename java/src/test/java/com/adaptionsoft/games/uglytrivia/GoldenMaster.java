package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GoldenMaster {

    public static final int MAX_SEED = 1000;

    public String getGameResult(long seed) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        GameRunner.play( new Random(seed) );

        return outputStream.toString();
    }

    public void generateGoldenMaster() throws IOException {
        for(long seed = 0; seed< MAX_SEED; seed++) {
            Path path = Paths.get (filename(seed));
            Files.write(path, getGameResult(seed).getBytes());
        }
    }

    private String filename(long seed) {
        return "goldenmasterdata/" + seed + ".txt";
    }

    public String getGoldenMaster(long seed) throws IOException, URISyntaxException {
        URL resource = this.getClass().getClassLoader().getResource(filename(seed));

        Path path = Paths.get(resource.toURI());
        List<String> lines = Files.readAllLines(path);

        String collect = lines.stream().collect(Collectors.joining(System.lineSeparator()));
        return collect+System.lineSeparator();
    }

}
