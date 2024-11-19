package redBlackTree;

import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {

    private Node root;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RedBlackTree() {
        root = null;
    }

    public void insertByDates(CSVRecord record) {
        root = insertRecByDates(root, record);
        root.isRed = false;
    }

    public void insertByPrice(CSVRecord record) {
        root = insertRecByPrice(root, record);
        root.isRed = false;
    }

    public void insertByAchievements(CSVRecord record) {
        root = insertRecByAchievements(root, record);
        root.isRed = false;
    }

    public void clear() {
        root = null;
    }

    private Node insertRecByDates(Node node, CSVRecord record) {
        LocalDate recordDate = LocalDate.parse(record.get(2), dateFormatter);

        if (node == null)
            return new Node(record, true);


        LocalDate currentDate = LocalDate.parse(node.record.get(2), dateFormatter);

        if (recordDate.isBefore(currentDate))
            node.left = insertRecByDates(node.left, record);
        else
            node.right = insertRecByDates(node.right, record);


        return balance(node);
    }

    private Node insertRecByPrice(Node node, CSVRecord record) {
        double recordPrice = Double.parseDouble(record.get(6));

        if (node == null)
            return new Node(record, true);


        double currentPrice = Double.parseDouble(node.record.get(6));

        if (recordPrice < currentPrice)
            node.left = insertRecByPrice(node.left, record);
        else
            node.right = insertRecByPrice(node.right, record);


        return balance(node);
    }

    private Node insertRecByAchievements(Node node, CSVRecord record) {
        int recordAchievements = Integer.parseInt(record.get(26));

        if (node == null)
            return new Node(record, true);


        int currentAchievements = Integer.parseInt(node.record.get(26));

        if (recordAchievements > currentAchievements)
            node.left = insertRecByAchievements(node.left, record);
        else
            node.right = insertRecByAchievements(node.right, record);


        return balance(node);
    }

    private Node balance(Node node) {
        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);


        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed;
    }

    private void flipColors(Node node) {
        node.isRed = !node.isRed;
        if (node.left != null) node.left.isRed = !node.left.isRed;
        if (node.right != null) node.right.isRed = !node.right.isRed;
    }

    private Node rotateLeft(Node node2) {
        Node node1 = node2.right;
        node2.right = node1.left;
        node1.left = node2;
        node1.isRed = node2.isRed;
        node2.isRed = true;
        return node1;
    }

    private Node rotateRight(Node node2) {
        Node node1 = node2.left;
        node2.left = node1.right;
        node1.right = node2;
        node1.isRed = node2.isRed;
        node2.isRed = true;
        return node1;
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
