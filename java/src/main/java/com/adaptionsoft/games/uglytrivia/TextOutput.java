package com.adaptionsoft.games.uglytrivia;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextOutput implements GameOutput {
    private final String fileName;

    public TextOutput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void consoleWriteLine(String message) throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName);
        byte[] lines = message.getBytes();
        Files.write(path, lines);
    }
}
