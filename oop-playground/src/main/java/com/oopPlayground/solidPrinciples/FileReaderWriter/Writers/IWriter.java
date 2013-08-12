package com.oopPlayground.solidPrinciples.FileReaderWriter.Writers;

import java.io.Writer;
import java.util.List;

public interface IWriter {

    void write(Writer writer, List<String> contents);
}

