package org.example;

import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.Path;

public interface OrdenationsInterface {
    public static CSVRecord[] readCsv(Path filePath) throws IOException {return null;}

    public static <T> void writeToCvs(String fileName, T recordElements) throws IOException{}

    public static CSVRecord[] invertElements(CSVRecord[] orderedElements){return null;}
}
