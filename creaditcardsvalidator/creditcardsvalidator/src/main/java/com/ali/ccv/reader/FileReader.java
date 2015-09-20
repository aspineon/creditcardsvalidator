package com.ali.ccv.reader;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import com.ali.ccv.error.ContingencyException;

public class FileReader implements Closeable {

    final String separator;
    private final Stream<String> lines;
    private Iterator<String> iterator;

    FileReader(final String separator, final String filePath) throws IOException {
        this.separator = separator;
        this.lines = Files.lines(Paths.get(filePath));
        this.iterator = this.lines.iterator();
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public LineStream nextLine() throws ContingencyException {
        String nextLine = "";
        try {
            nextLine = this.iterator.next();
            return new LineStream(nextLine.split(this.separator));
        } catch (ContingencyException e) {
            throw new ContingencyException("Line is in an invalid format. Separator: " + this.separator + "; Line: " + nextLine);
        }
    }

    @Override
    public void close() throws IOException {
        this.lines.close();
    }

}
