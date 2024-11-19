package ordenations;
import org.apache.commons.csv.CSVRecord;
import redBlackTree.RedBlackTree;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class OrdenationsRedBlackTree extends Ordenations{
        public static void mainOrdenationsRedBlackTree() throws IOException {
            long startTime, endTime, execTime;
            Path pathToGamesFormated = Paths.get("src", "main", "java", "database", "games_formated_release_data.csv");
            CSVRecord[] elements = readCsv(pathToGamesFormated);

            System.out.println("ORDENAÇÕES POR DATAS");
            RedBlackTree treeByDates = new RedBlackTree();

            System.out.println("Ordenação por datas Médio Caso");
            assert elements != null;
            startTime = System.currentTimeMillis();
            for (CSVRecord record : elements) {
                treeByDates.insertByDates(record);
            }
            endTime = System.currentTimeMillis();
            execTime = endTime - startTime;
            System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

            List<CSVRecord> treeElements = treeByDates.toList();
            writeToCsv("games_releaseDates_RedBlackTree_casoMedio.csv", treeElements);

            Path filePath = Paths.get("src", "main", "java", "database", "games_releaseDates_RedBlackTree_casoMedio.csv");
            elements = readCsv(filePath);
            treeByDates.clear();
            assert elements != null;

            System.out.println("Ordenação por datas piorCaso(Elementos em ordem)");
            startTime = System.currentTimeMillis();
            for (CSVRecord record : elements) {
                treeByDates.insertByDates(record);
            }
            endTime = System.currentTimeMillis();
            execTime = endTime - startTime;
            System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

            treeElements = treeByDates.toList();
            writeToCsv("games_releaseDates_RedBlackTree_piorCaso.csv", treeElements);

            elements = readCsv(filePath);
            elements = invertElements(elements);
            treeByDates.clear();

            System.out.println("Ordenação por datas Melhor caso(Elementos em ordem inversa)");
            assert elements != null;
            startTime = System.currentTimeMillis();
            for (CSVRecord record : elements) {
                treeByDates.insertByDates(record);
            }
            endTime = System.currentTimeMillis();
            execTime = endTime - startTime;
            System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

            treeElements = treeByDates.toList();
            writeToCsv("games_releaseDates_RedBlackTree_melhorCaso.csv", treeElements);

            System.out.println("ORDENAÇÕES POR PREÇO");
            elements = readCsv(pathToGamesFormated);
            RedBlackTree treeByPrice = new RedBlackTree();

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
            writeToCsv("games_price_RedBlackTree_casoMedio.csv", treeElements);

            filePath = Paths.get("src", "main", "java", "database", "games_price_RedBlackTree_casoMedio.csv");
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
            writeToCsv("games_price_RedBlackTree_piorCaso.csv", treeElements);

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
            writeToCsv("games_price_RedBlackTree_melhorCaso.csv", treeElements);

            System.out.println("ORDENAÇÕES POR CONQUISTAS");
            elements = readCsv(pathToGamesFormated);
            RedBlackTree treeByAchievements = new RedBlackTree();

            System.out.println("Ordenação por conquistas Médio caso");
            assert elements != null;
            startTime = System.currentTimeMillis();
            for (CSVRecord record : elements) {
                treeByAchievements.insertByAchievements(record);
            }
            endTime = System.currentTimeMillis();
            execTime = endTime - startTime;
            System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

            treeElements = treeByAchievements.toList();
            writeToCsv("games_achievements_RedBlackTree_casoMedio.csv", treeElements);


            filePath = Paths.get("src", "main", "java", "database", "games_achievements_RedBlackTree_casoMedio.csv");
            elements = readCsv(filePath);
            treeByAchievements.clear();
            assert elements != null;

            System.out.println("Ordenação por conquistas Pior Caso(Elementos em ordem)");
            startTime = System.currentTimeMillis();
            for (CSVRecord record : elements) {
                treeByAchievements.insertByAchievements(record);
            }
            endTime = System.currentTimeMillis();
            execTime = endTime - startTime;
            System.out.println("Tempo de execução: " + execTime + " Millisegundos ou " + execTime/1000 + " Segundos");

            treeElements = treeByAchievements.toList();
            writeToCsv("games_achievements_RedBlackTree_piorCaso.csv", treeElements);

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
            writeToCsv("games_achievements_RedBlackTree_melhorCaso.csv", treeElements);
        }
    }

