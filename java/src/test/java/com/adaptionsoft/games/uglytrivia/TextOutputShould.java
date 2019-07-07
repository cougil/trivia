package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextOutputShould {

    @Test
    void write_a_line_of_text() throws IOException {
        String fileName = "example_fileName.txt";
        Path path = FileSystems.getDefault().getPath(fileName);
        Files.deleteIfExists(path);

        TextOutput textOutput = new TextOutput(fileName);
        textOutput.consoleWriteLine("an example line");

        assertEquals("an example line", readText(fileName));
    }

    private String readText(String fileName) throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName);
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        return lines.get(0);
    }
}