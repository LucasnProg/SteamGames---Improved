package ordenations;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ordenations implements OrdenationsInterface {
    public static CSVRecord[] readCsv(Path filePath) throws IOException {
        File file = filePath.toFile();

        try (
                Reader reader = new FileReader(file);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
        ) {
            List<CSVRecord> records = csvParser.getRecords();

            CSVRecord[] array = new CSVRecord[records.size()];
            for (int index = 0; index < records.size(); index++) {
                array[index] = records.get(index);
            }
            return array;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static void writeToCsv(String fileName, List<CSVRecord> records) throws IOException {
        Path databasePath = Paths.get("src", "main", "java", "database");
        File outputFile = new File(databasePath.toString(), fileName);
        File fileToGetHeader = new File(databasePath.toString(), "portuguese_supported_games.csv");

        try (
                Writer writer = new FileWriter(outputFile);
                CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
                Reader reader = new FileReader(fileToGetHeader);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ) {
            printer.printRecord(csvParser.getHeaderMap().keySet());

            for (CSVRecord record : records) {
                printer.printRecord(record);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static CSVRecord[] invertElements(CSVRecord[] orderedElements){
        int start = 0;
        int end = orderedElements.length - 1;
        CSVRecord[] resultArray = orderedElements.clone();

        while (start < end) {
            CSVRecord swap = resultArray[start];
            resultArray[start] = resultArray[end];
            resultArray[end] = swap;

            start++;
            end--;
        }

        return resultArray;
    }
}
