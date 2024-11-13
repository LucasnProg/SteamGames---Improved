package org.example;

import avlTree.AvlTree;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class OrdenationsAvlTree extends Ordenations {
    public static void mainOrdenationsAvlTree() throws IOException {
        Path pathToGamesFormated = Paths.get("src", "main", "java", "database", "games_formated_release_data.csv");
        CSVRecord[] elements = readCsv(pathToGamesFormated);
        System.out.println("Os elementos foram lidos, para serem inseridos de maneira ordenada na árvore AVL.");

        AvlTree treeByDates = new AvlTree();

        System.out.println("Ordenação por datas a partir da base original");
        assert elements != null;
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }

        List<CSVRecord> treeElements = treeByDates.toList();
        writeToCsv("games_release_date_AvlTree_casoMedio.csv", treeElements);

        System.out.println("Ordenação por datas a partir da base já ordenada");
        Path filePath = Paths.get("src", "main", "java", "database", "games_release_date_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByDates.clear();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }

        treeElements = treeByDates.toList();
        writeToCsv("games_release_date_AvlTree_MelhorCaso.csv", treeElements);

        System.out.println("Ordenação por datas a partir da base ordenada de maneira inversa");
        elements = readCsv(filePath);
        assert elements != null;
        elements = invertElements(elements);
        treeByDates.clear();
        for (CSVRecord record : elements) {
            treeByDates.insertByDates(record);
        }

        treeElements = treeByDates.toList();
        writeToCsv("games_release_date_AvlTree_PiorCaso.csv", treeElements);

        System.out.println("Iniciando operações com preços...");

        elements = readCsv(pathToGamesFormated);
        System.out.println("Os elementos foram lidos, para serem inseridos de maneira ordenada na árvore AVL.");
        AvlTree treeByPrice = new AvlTree();

        System.out.println("Ordenação por preços a partir da base original");
        assert elements != null;
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_casoMedio.csv", treeElements);

        System.out.println("Ordenação por preço a partir da base já ordenada");
        filePath = Paths.get("src", "main", "java", "database", "games_price_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByPrice.clear();

        System.out.println("Ordenação por preços a partir da base já ordenada");
        assert elements != null;
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_MelhorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByPrice.clear();

        System.out.println("Ordenação por preços a partir da base ordenada de maneira inversa");
        assert elements != null;
        for (CSVRecord record : elements) {
            treeByPrice.insertByPrice(record);
        }

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_AvlTree_PiorCaso.csv", treeElements);

        System.out.println("Iniciando operações com Conquistas...");

        elements = readCsv(pathToGamesFormated);
        System.out.println("Os elementos foram lidos, para serem inseridos de maneira ordenada na árvore AVL.");
        AvlTree treeByAchievements = new AvlTree();

        System.out.println("Ordenação por conquistas a partir da base original");
        assert elements != null;
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_casoMedio.csv", treeElements);

        System.out.println("Ordenação por conquistas a partir da base já ordenada");
        filePath = Paths.get("src", "main", "java", "database", "games_achievements_AvlTree_casoMedio.csv");
        elements = readCsv(filePath);
        treeByAchievements.clear();

        System.out.println("Ordenação por conquistas a partir da base já ordenada");
        assert elements != null;
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_MelhorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByAchievements.clear();

        System.out.println("Ordenação por conquistas a partir da base ordenada de maneira inversa");
        assert elements != null;
        for (CSVRecord record : elements) {
            treeByAchievements.insertByAchievements(record);
        }

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_AvlTree_PiorCaso.csv", treeElements);

        System.out.println("Foram executadas todas as operações usando árvore AVL.");
    }
}

