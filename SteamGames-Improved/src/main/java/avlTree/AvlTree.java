package avlTree;

import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AvlTree {

    private Node root;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AvlTree() {
        root = null;
    }

    public void insertByDates(CSVRecord record) {
        root = insertRecByDates(root, record);
    }

    public void insertByPrice(CSVRecord record) {
        root = insertRecByPrice(root, record);
    }

    public void insertByAchievements(CSVRecord record) {
        root = insertRecByAchievements(root, record);
    }

    public void clear() {
        root = null;
    }

    private Node insertRecByDates(Node node, CSVRecord record) {
        LocalDate recordDate = LocalDate.parse(record.get(2), dateFormatter);

        if (node == null)
            return new Node(record);


        LocalDate currentDate = LocalDate.parse(node.record.get(2), dateFormatter);

        if (recordDate.isBefore(currentDate))
            node.left = insertRecByDates(node.left, record);
        else
            node.right = insertRecByDates(node.right, record);


        node = balance(node);
        return node;
    }

    private Node insertRecByPrice(Node node, CSVRecord record) {
        double recordPrice = Double.parseDouble(record.get(6));

        if (node == null)
            return new Node(record);


        double currentPrice = Double.parseDouble(node.record.get(6));

        if (recordPrice < currentPrice)
            node.left = insertRecByPrice(node.left, record);
        else
            node.right = insertRecByPrice(node.right, record);


        node = balance(node);
        return node;
    }

    private Node insertRecByAchievements(Node node, CSVRecord record) {
        int recordAchievements = Integer.parseInt(record.get(26));

        if (node == null)
            return new Node(record);


        int currentAchievements = Integer.parseInt(node.record.get(26));

        if (recordAchievements > currentAchievements)
            node.left = insertRecByAchievements(node.left, record);
        else
            node.right = insertRecByAchievements(node.right, record);


        node = balance(node);
        return node;
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node balance(Node node) {
        int balanceFactor = getBalance(node);

        if (balanceFactor > 1) {
            if (getBalance(node.left) >= 0)
                node = rotateRight(node);
            else
                node = rotateLeftRight(node);
        } else if (balanceFactor < -1) {
            if (getBalance(node.right) <= 0)
                node = rotateLeft(node);
            else
                node = rotateRightLeft(node);

        } else
            node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    private Node rotateLeft(Node node2) {
        Node node1 = node2.right;
        node2.right = node1.left;
        node1.left = node2;
        node2.height = Math.max(height(node2.left), height(node2.right)) + 1;
        node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
        return node1;
    }

    private Node rotateRight(Node node1) {
        Node node2 = node1.left;
        node1.left = node2.right;
        node2.right = node1;
        node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
        node2.height = Math.max(height(node2.left), height(node2.right)) + 1;
        return node2;
    }

    private Node rotateLeftRight(Node node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private Node rotateRightLeft(Node node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    public List<CSVRecord> toList() {
        List<CSVRecord> resultList = new ArrayList<>();
        inorderTraversal(root, resultList);
        return resultList;
    }

    private void inorderTraversal(Node node, List<CSVRecord> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.record);
            inorderTraversal(node.right, list);
        }
    }

}
