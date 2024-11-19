package ordenations;

import binarySearchTree.BinarySearchTree;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class OrdenationsBinarySearchTree extends Ordenations{
    public static void mainOrdenationsBinarySearchTree() throws IOException {
        long startTime, endTime, execTime;
        Path pathToGamesFormated = Paths.get("src", "main", "java", "database", "games_formated_release_data.csv");
        CSVRecord[] elements = readCsv(pathToGamesFormated);
        BinarySearchTree treeByDates = new BinarySearchTree();
        System.out.println("ORDENAÇÕES POR DATAS");
        System.out.println("Ordenação por datas Médio caso:");

        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByDates.insertByDates(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        List<CSVRecord> treeElements = treeByDates.toList();
        writeToCsv("games_release_date_ArvoreBinaria_casoMedio.csv", treeElements);


        System.out.println("Ordenação por datas Pior caso(elementos em ordem)");
        Path filePath = Paths.get("src", "main", "java", "database", "games_release_date_ArvoreBinaria_casoMedio.csv");
        elements = readCsv(filePath);
        treeByDates.clear();

        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByDates.insertByDates(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByDates.toList();
        writeToCsv("games_release_date_ArvoreBinaria_piorCaso.csv", treeElements);

        System.out.println("Ordenação por datas Melhor caso(Elementos em ordem inversa)");
        elements = readCsv(filePath);
        assert elements != null;
        elements = invertElements(elements);
        treeByDates.clear();

        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByDates.insertByDates(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");
        treeElements = treeByDates.toList();
        writeToCsv("games_release_date_ArvoreBinaria_melhorCaso.csv", treeElements);

        System.out.println("\nORDENAÇÕES POR PREÇOS");

        elements = readCsv(pathToGamesFormated);
        BinarySearchTree treeByPrice = new BinarySearchTree();

        System.out.println("Ordenação por precos Médio caso");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByPrice.insertByPrice(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_ArvoreBinaria_casoMedio.csv", treeElements);

        System.out.println("Ordenação por preço Pior caso");
        filePath = Paths.get("src", "main", "java", "database", "games_price_ArvoreBinaria_casoMedio.csv");
        elements = readCsv(filePath);
        treeByPrice.clear();

        System.out.println("Ordenação por preços Pior caso(Elementos em ordem)");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByPrice.insertByPrice(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_ArvoreBinaria_piorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByPrice.clear();

        System.out.println("Ordenação por preços Melhor caso(Elementos em ordem inversa)");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByPrice.insertByPrice(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByPrice.toList();
        writeToCsv("games_price_ArvoreBinaria_melhorCaso.csv", treeElements);

        System.out.println("ORDENAÇÕES POR CONQUISTAS");

        elements = readCsv(pathToGamesFormated);
        BinarySearchTree treeByAchievements = new BinarySearchTree();

        System.out.println("Ordenação por conquistas Médio caso");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByAchievements.insertByAchievements(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_ArvoreBinaria_casoMedio.csv", treeElements);

        System.out.println("Ordenação por conquistas pior caso(Elementos ordenados)");
        filePath = Paths.get("src", "main", "java", "database", "games_achievements_ArvoreBinaria_casoMedio.csv");
        elements = readCsv(filePath);
        treeByAchievements.clear();

        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByAchievements.insertByAchievements(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_ArvoreBinaria_piorCaso.csv", treeElements);

        elements = readCsv(filePath);
        elements = invertElements(elements);
        treeByAchievements.clear();

        System.out.println("Ordenação por conquistas Melhor caso(Elementos em ordem inversa)");
        assert elements != null;
        startTime = System.currentTimeMillis();
        for (CSVRecord record : elements){
            treeByAchievements.insertByAchievements(record);
        }
        endTime = System.currentTimeMillis();
        execTime = endTime - startTime;
        System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

        treeElements = treeByAchievements.toList();
        writeToCsv("games_achievements_ArvoreBinaria_melhorCaso.csv", treeElements);
    }
}
