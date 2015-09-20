package com.ali.ccv.reader;

public enum FileFormat {

    CSV(","),
    PIPE("\\|"),
    TAB("\t");

    private final String separator;

    private FileFormat(final String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return this.separator;
    }

}
