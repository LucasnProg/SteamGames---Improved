package org.example;

import avlTree.AvlTree;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class OrdenationsAvlTree extends Ordenations {
    public static void mainOrdenationsAvlTree() throws IOException {
        long startTime, endTime, execTime, memoryBefore, memoryAfter, memoryUsed;
        Path pathToGamesFormated = Paths.get("src", "main", "java", "database", "games_formated_release_data.csv");
        CSVRecord[] elements = readCsv(pathToGamesFormated);
        System.out.println("Iniciando operações com datas...");
        AvlTree treeByDates = new AvlTree();

        System.out.println("Ordenação por preços a partir da base original");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        List<CSVRecord> treeElements = treeByDates.toList();
        writeToCsv("games_releaseDates_AvlTree_casoMedio.csv", treeElements);

        System.out.println("Ordenação por datas a partir da base já ordenada");
        Path filePath = Paths.get("src", "main", "java", "database", "games_releaseDates_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByDates.clear();
        assert elements != null;

        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByDates.toList();
        writeToCsv("games_releaseDates_AvlTree_MelhorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByDates.clear();

        System.out.println("Ordenação por Datas a partir da base ordenada de maneira inversa");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByDates.toList();
        writeToCsv("games_releaseDates_AvlTree_PiorCaso.csv", treeElements);


        System.out.println("Iniciando operações com preços...");
        elements = readCsv(pathToGamesFormated);
        AvlTree treeByPrice = new AvlTree();

        System.out.println("Ordenação por preços a partir da base original");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_casoMedio.csv", treeElements);

        System.out.println("Ordenação por preços a partir da base já ordenada");
        filePath = Paths.get("src", "main", "java", "database", "games_price_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByPrice.clear();
        assert elements != null;

        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_MelhorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByPrice.clear();

        System.out.println("Ordenação por preços a partir da base ordenada de maneira inversa");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_PiorCaso.csv", treeElements);

        System.out.println("Iniciando operações com conquistas...");

        elements = readCsv(pathToGamesFormated);
        AvlTree treeByAchievements = new AvlTree();

        System.out.println("Ordenação por conquistas a partir da base original");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_casoMedio.csv", treeElements);

        System.out.println("Ordenação por conquistas a partir da base já ordenada");
        filePath = Paths.get("src", "main", "java", "database", "games_achievements_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByAchievements.clear();
        assert elements != null;

        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_MelhorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByAchievements.clear();

        System.out.println("Ordenação por conquistas a partir da base ordenada de maneira inversa");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_PiorCaso.csv", treeElements);

        System.out.println("Foram executadas todas as operações usando a árvore AVL.");
    }
}
