package binarySearchTree;

import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree{

    private Node root;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public BinarySearchTree() {
        root = null;
    }

    public void insertByDates(CSVRecord record) {
        root = insertRecByDates(root, record);
    }
    public void insertByPrice(CSVRecord record) {
        root = insertByPriceRec(root, record);
    }
    public void insertByAchievements(CSVRecord record) {
        root = insertByAchievementsRec(root, record);
    }
    
    public void clear(){
        root = null;
    }
    private Node insertRecByDates(Node root, CSVRecord record) {
        if (root == null) {
            root = new Node(record);
            return root;
        }

        LocalDate recordDate = LocalDate.parse(record.get(2), dateFormatter);
        LocalDate rootDate = LocalDate.parse(root.record.get(2), dateFormatter);

        if (recordDate.isBefore(rootDate)) {
            root.left = insertRecByDates(root.left, record);
        } else if (recordDate.isAfter(rootDate)) {
            root.right = insertRecByDates(root.right, record);
        } else {
            root.right = insertRecByDates(root.right, record);
        }

        return root;
    }
    private Node insertRecByDatesOrden(Node root, CSVRecord record) {
        if (root == null) {
            root = new Node(record);
            return root;
        }

        LocalDate recordDate = LocalDate.parse(record.get(2), dateFormatter);
        LocalDate rootDate = LocalDate.parse(root.record.get(2), dateFormatter);

        if (recordDate.isBefore(rootDate)) {
            root.left = insertRecByDates(root.left, record);
        } else if (recordDate.isAfter(rootDate)) {
            root.right = insertRecByDates(root.right, record);
        } else {
            root.left = insertRecByDates(root.left, record);
        }

        return root;
    }

    private Node insertByPriceRec(Node root, CSVRecord record) {
        if (root == null) {
            root = new Node(record);
            return root;
        }

        double recordPrice = Double.parseDouble(record.get(6));
        double rootPrice = Double.parseDouble(root.record.get(6));

        if (recordPrice < rootPrice) {
            root.left = insertByPriceRec(root.left, record);
        } else if (recordPrice > rootPrice) {
            root.right = insertByPriceRec(root.right, record);
        } else {
            root.right = insertByPriceRec(root.right, record);
        }

        return root;
    }

    private Node insertByAchievementsRec(Node root, CSVRecord record) {
        if (root == null) {
            root = new Node(record);
            return root;
        }

        int recordAchievements = Integer.parseInt(record.get(26));
        int rootAchievements = Integer.parseInt(root.record.get(26));

        if (recordAchievements > rootAchievements) {
            root.left = insertByAchievementsRec(root.left, record);
        } else if (recordAchievements < rootAchievements) {
            root.right = insertByAchievementsRec(root.right, record);
        } else {
            root.right = insertByAchievementsRec(root.right, record);
        }

        return root;
    }

    // Método para imprimir a árvore em ordem pela data
    public void inorderByDates() {
        inorderRecByDates(root);
    }
    public void inorderByPrice() {
        inorderRecByPrice(root);
    }
    public void inorderByAchievements() {
        inorderByAchievementsRec(root);
    }
    private void inorderByAchievementsRec(Node root) {
        if (root != null) {
            inorderByAchievementsRec(root.left);
            System.out.println("Achievements: " + root.record.get(26) + " | Record: " + root.record);
            inorderByAchievementsRec(root.right);
        }
    }
    private void inorderRecByDates(Node root) {
        if (root != null) {
            inorderRecByDates(root.left);
            System.out.println("Date: " + root.record.get(2) + " | Record: " + root.record);
            inorderRecByDates(root.right);
        }
    }

    private void inorderRecByPrice(Node root) {
        if (root != null) {
            inorderRecByPrice(root.left);
            System.out.println("Price: " + root.record.get(6) + " | Record: " + root.record);
            inorderRecByPrice(root.right);
        }
    }

    public List<CSVRecord> toList() {
        List<CSVRecord> recordsList = new ArrayList<>();
        inorderToList(root, recordsList);
        return recordsList;
    }

    private void inorderToList(Node node, List<CSVRecord> list) {
        if (node != null) {
            inorderToList(node.left, list);
            list.add(node.record);  // Adiciona o CSVRecord à lista
            inorderToList(node.right, list);
        }
    }

}
