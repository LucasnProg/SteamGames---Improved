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
    public static int getHeight(Node no){
        return no == null ? -1 : no.height;
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

    public void clear() {
        root = null;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeftRight(Node node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private Node rotateRightLeft(Node node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    // Inserções com base em diferentes critérios
    private Node insertRecByDates(Node root, CSVRecord record) {
        if (root == null) return new Node(record);
        LocalDate recordDate = LocalDate.parse(record.get(2), dateFormatter);
        LocalDate rootDate = LocalDate.parse(root.record.get(2), dateFormatter);

        if (recordDate.isBefore(rootDate)) root.left = insertRecByDates(root.left, record);
        else if (recordDate.isAfter(rootDate)) root.right = insertRecByDates(root.right, record);
        else root.right = insertRecByDates(root.right, record);

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = getBalance(root);

        if (balance > 1 && recordDate.isBefore(LocalDate.parse(root.left.record.get(2), dateFormatter))) return rotateRight(root);
        if (balance < -1 && recordDate.isAfter(LocalDate.parse(root.right.record.get(2), dateFormatter))) return rotateLeft(root);
        if (balance > 1 && recordDate.isAfter(LocalDate.parse(root.left.record.get(2), dateFormatter))) return rotateLeftRight(root);
        if (balance < -1 && recordDate.isBefore(LocalDate.parse(root.right.record.get(2), dateFormatter))) return rotateRightLeft(root);

        return root;
    }

    private Node insertByPriceRec(Node root, CSVRecord record) {
        if (root == null) return new Node(record);
        double recordPrice = Double.parseDouble(record.get(6));
        double rootPrice = Double.parseDouble(root.record.get(6));

        if (recordPrice < rootPrice) root.left = insertByPriceRec(root.left, record);
        else if (recordPrice > rootPrice) root.right = insertByPriceRec(root.right, record);
        else root.right = insertByPriceRec(root.right, record);

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = getBalance(root);

        if (balance > 1 && recordPrice < Double.parseDouble(root.left.record.get(6))) return rotateRight(root);
        if (balance < -1 && recordPrice > Double.parseDouble(root.right.record.get(6))) return rotateLeft(root);
        if (balance > 1 && recordPrice > Double.parseDouble(root.left.record.get(6))) return rotateLeftRight(root);
        if (balance < -1 && recordPrice < Double.parseDouble(root.right.record.get(6))) return rotateRightLeft(root);

        return root;
    }

    private Node insertByAchievementsRec(Node root, CSVRecord record) {
        if (root == null) return new Node(record);
        int recordAchievements = Integer.parseInt(record.get(26));
        int rootAchievements = Integer.parseInt(root.record.get(26));

        if (recordAchievements > rootAchievements) root.left = insertByAchievementsRec(root.left, record);
        else if (recordAchievements < rootAchievements) root.right = insertByAchievementsRec(root.right, record);
        else root.right = insertByAchievementsRec(root.right, record);

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = getBalance(root);

        if (balance > 1 && recordAchievements > Integer.parseInt(root.left.record.get(26))) return rotateRight(root);
        if (balance < -1 && recordAchievements < Integer.parseInt(root.right.record.get(26))) return rotateLeft(root);
        if (balance > 1 && recordAchievements < Integer.parseInt(root.left.record.get(26))) return rotateLeftRight(root);
        if (balance < -1 && recordAchievements > Integer.parseInt(root.right.record.get(26))) return rotateRightLeft(root);

        return root;
    }

    public List<CSVRecord> toList() {
        List<CSVRecord> resultList = new ArrayList<>();
        inOrderTraversal(root, resultList);
        return resultList;
    }

    private void inOrderTraversal(Node node, List<CSVRecord> resultList) {
        if (node != null) {
            inOrderTraversal(node.left, resultList);
            resultList.add(node.record);
            inOrderTraversal(node.right, resultList);
        }
    }

}
