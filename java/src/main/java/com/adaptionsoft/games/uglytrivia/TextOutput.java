package com.adaptionsoft.games.uglytrivia;

import java.io.IOException;
import java.nio.file.*;

public class TextOutput implements GameOutput {
    private final String fileName;

    public TextOutput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void consoleWriteLine(String message) throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName);
        message = message.concat(System.lineSeparator());
        byte[] lines = message.getBytes();
        if (!Files.exists(path)) {
            Files.write(path, new byte[]{}, StandardOpenOption.CREATE_NEW);
        }
        Files.write(path, lines, StandardOpenOption.APPEND);
    }
}
