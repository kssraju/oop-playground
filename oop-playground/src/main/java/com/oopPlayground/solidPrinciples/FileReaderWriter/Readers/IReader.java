package com.oopPlayground.solidPrinciples.FileReaderWriter.Readers;

import java.io.Reader;
import java.util.List;

public interface IReader {

    List<String> read(Reader reader);
}

