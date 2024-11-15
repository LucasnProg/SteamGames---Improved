package org.example;

import binarySearchTree.BinarySearchTree;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class OrdenationsBinarySearchTree extends Ordenations{
    public static void mainOrdenationsBinarySearchTree() throws IOException {
        long startTime, endTime, execTime, memoryBefore, memoryAfter, memoryUsed;
        Path pathToGamesFormated = Paths.get("src", "main", "java", "database", "games_formated_release_data.csv");
        CSVRecord[] elements = readCsv(pathToGamesFormated);
        BinarySearchTree treeByDates = new BinarySearchTree();
        System.out.println("Ordenação por datas a partir da base original");

        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByDates.insertByDates(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        List<CSVRecord> treeElements = treeByDates.toList();
        writeToCsv("games_release_date_ArvoreBinaria_casoMedio.csv", treeElements);


        System.out.println("Ordenação por datas a partir da base ja ordenada");
        Path filePath = Paths.get("src", "main", "java", "database", "games_release_date_ArvoreBinaria_casoMedio.csv");
        elements = readCsv(filePath);
        treeByDates.clear();

        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByDates.insertByDates(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByDates.toList();
        writeToCsv("games_release_date_ArvoreBinaria_MelhorCaso.csv", treeElements);

        System.out.println("Ordenação por datas a partir da base ordenada de maneira inversa");
        elements = readCsv(filePath);
        assert elements != null;
        elements = invertElements(elements);
        treeByDates.clear();

        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByDates.insertByDates(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByDates.toList();
        writeToCsv("games_release_date_ArvoreBinaria_PiorCaso.csv", treeElements);

        System.out.println("Iniciando operações com preços...");

        elements = readCsv(pathToGamesFormated);
        System.out.println("Os elementos foram lidos, para serem inseridos de maneira ordenada na árvore binária de busca.");
        BinarySearchTree treeByPrice = new BinarySearchTree();

        System.out.println("Ordenação por precos apartir da base original");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByPrice.insertByPrice(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_ArvoreBinaria_casoMedio.csv", treeElements);

        System.out.println("Ordenação por preço a partir da base ja ordenada");
        filePath = Paths.get("src", "main", "java", "database", "games_price_ArvoreBinaria_casoMedio.csv");
        elements = readCsv(filePath);
        treeByPrice.clear();

        System.out.println("Ordenação por preços a partir da base ja ordenada");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByPrice.insertByPrice(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_ArvoreBinaria_MelhorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByPrice.clear();

        System.out.println("Ordenação por preços apartir da base ordenada de maneira inversa");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByPrice.insertByPrice(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_ArvoreBinaria_PiorCaso.csv", treeElements);

        System.out.println("Iniciando operações com Conquistas...");

        elements = readCsv(pathToGamesFormated);
        System.out.println("Os elementos foram lidos, para serem inseridos de maneira ordenada na árvore binária de busca.");
        BinarySearchTree treeByAchievements = new BinarySearchTree();

        System.out.println("Ordenação por conquistas apartir da base original");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByAchievements.insertByAchievements(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_ArvoreBinaria_casoMedio.csv", treeElements);

        System.out.println("Ordenação por conquistas a partir da base ja ordenada");
        filePath = Paths.get("src", "main", "java", "database", "games_achievements_ArvoreBinaria_casoMedio.csv");
        elements = readCsv(filePath);
        treeByAchievements.clear();

        System.out.println("Ordenação por conquistas a partir da base ja ordenada");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByAchievements.insertByAchievements(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_ArvoreBinaria_MelhorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByAchievements.clear();

        System.out.println("Ordenação por conquistas apartir da base ordenada de maneira inversa");
        assert elements != null;
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        for (CSVRecord record : elements){
            treeByAchievements.insertByAchievements(record);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = Math.abs((memoryAfter - memoryBefore) / (1024 * 1024));
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        System.out.println("Memória utilizada: " + memoryUsed + " Megabytes\n");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_ArvoreBinaria_PiorCaso.csv", treeElements);

        System.out.println("Foram executadas todas as operações usando arvore binaria de busca");
    }
}
