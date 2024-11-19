package ordenations;

import avlTree.AvlTree;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class OrdenationsAvlTree extends Ordenations {
    public static void mainOrdenationsAvlTree() throws IOException {
        long startTime, endTime, execTime;
        Path pathToGamesFormated = Paths.get("src", "main", "java", "database", "games_formated_release_data.csv");
        CSVRecord[] elements = readCsv(pathToGamesFormated);
        System.out.println("ORDENAÇÕES POR DATAS");
        AvlTree treeByDates = new AvlTree();

        System.out.println("Ordenação por datas Médio caso");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        List<CSVRecord> treeElements = treeByDates.toList();
        writeToCsv("games_releaseDates_AvlTree_casoMedio.csv", treeElements);

        System.out.println("Ordenação por datas Pior caso(Elementos em ordem)");
        Path filePath = Paths.get("src", "main", "java", "database", "games_releaseDates_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByDates.clear();
        assert elements != null;

        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByDates.toList();
        writeToCsv("games_releaseDates_AvlTree_piorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByDates.clear();

        System.out.println("Ordenação por Datas Melhor caso(Elementos em ordem inversa)");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByDates.toList();
        writeToCsv("games_releaseDates_AvlTree_melhorCaso.csv", treeElements);


        System.out.println("ORDENAÇÕES POR PREÇOS");
        elements = readCsv(pathToGamesFormated);
        AvlTree treeByPrice = new AvlTree();

        System.out.println("Ordenação por preços Médio caso");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_casoMedio.csv", treeElements);


        filePath = Paths.get("src", "main", "java", "database", "games_price_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByPrice.clear();
        assert elements != null;

        System.out.println("Ordenação por preços pior caso(Elementos em ordem)");
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_piorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByPrice.clear();

        System.out.println("Ordenação por preços Melhor caso(Elementos em ordem inversa)");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_melhorCaso.csv", treeElements);

        System.out.println("ORDENAÇÕES POR CONQUISTAS");

        elements = readCsv(pathToGamesFormated);
        AvlTree treeByAchievements = new AvlTree();

        System.out.println("Ordenação por conquistas Médio Caso");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_casoMedio.csv", treeElements);


        filePath = Paths.get("src", "main", "java", "database", "games_achievements_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByAchievements.clear();
        assert elements != null;

        System.out.println("Ordenação por conquistas Pior Caso(Elementos em Ordem)");
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_piorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByAchievements.clear();

        System.out.println("Ordenação por conquistas Melhor caso(Elementos em ordem inversa)");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_melhorCaso.csv", treeElements);

    }
}
