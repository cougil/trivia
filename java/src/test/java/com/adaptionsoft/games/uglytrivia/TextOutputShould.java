package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextOutputShould {

    @Test
    void write_a_line_of_text_to_file() throws IOException {
        String fileName = "example_fileName.txt";
        Path path = FileSystems.getDefault().getPath(fileName);
        Files.deleteIfExists(path);

        TextOutput textOutput = new TextOutput(fileName);
        textOutput.consoleWriteLine("an example line");

        assertEquals("an example line", readText(fileName));
    }

    @Test
    void write_two_lines_of_text_to_file() throws IOException {
        String fileName = "example_fileName_twoLines.txt";
        Path path = FileSystems.getDefault().getPath(fileName);
        Files.deleteIfExists(path);

        TextOutput textOutput = new TextOutput(fileName);
        textOutput.consoleWriteLine("an example line");
        textOutput.consoleWriteLine("another example line");

        assertEquals("an example line\n" +
                "another example line", readText(fileName));
    }

    private String readText(String fileName) throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName);
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        return lines.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}