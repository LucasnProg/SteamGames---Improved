package binarySearchTree;

import org.apache.commons.csv.CSVRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public BinarySearchTree() {
        root = null;
    }

    public void insertByDates(CSVRecord record) {
        root = insertIterByDates(root, record);
    }

    public void insertByPrice(CSVRecord record) {
        root = insertIterByPrice(root, record);
    }

    public void insertByAchievements(CSVRecord record) {
        root = insertIterByAchievements(root, record);
    }

    public void clear() {
        root = null;
    }

    private Node insertIterByDates(Node root, CSVRecord record) {
        LocalDate currentDate = LocalDate.parse(record.get(2), dateFormatter);

        if (root == null)
            return new Node(record);


        Node currentNode = root;
        while (true) {
            LocalDate rootDate = LocalDate.parse(currentNode.record.get(2), dateFormatter);

            if (currentDate.isBefore(rootDate)) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(record);
                    break;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(record);
                    break;
                }
                currentNode = currentNode.right;
            }
        }

        return root;
    }

    private Node insertIterByPrice(Node root, CSVRecord record) {
        double currentPrice = Double.parseDouble(record.get(6));

        if (root == null)
            return new Node(record);


        Node currentNode = root;
        while (true) {
            double rootPrice = Double.parseDouble(currentNode.record.get(6));

            if (currentPrice < rootPrice) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(record);
                    break;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(record);
                    break;
                }
                currentNode = currentNode.right;
            }
        }

        return root;
    }

    private Node insertIterByAchievements(Node root, CSVRecord record) {
        int currentAchievements = Integer.parseInt(record.get(26));

        if (root == null)
            return new Node(record);


        Node currentNode = root;
        while (true) {
            int rootAchievements = Integer.parseInt(currentNode.record.get(26));

            if (currentAchievements > rootAchievements) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(record);
                    break;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(record);
                    break;
                }
                currentNode = currentNode.right;
            }
        }

        return root;
    }

    public List<CSVRecord> toList() {
        List<CSVRecord> recordsList = new ArrayList<>();
        inorderTraversal(root, recordsList);
        return recordsList;
    }

    private void inorderTraversal(Node root, List<CSVRecord> list) {
        Node currentNode = root;

        while (currentNode != null) {
            if (currentNode.left == null) {
                list.add(currentNode.record);
                currentNode = currentNode.right;
            } else {
                Node predecessor = currentNode.left;
                while (predecessor.right != null && predecessor.right != currentNode) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    predecessor.right = null;
                    list.add(currentNode.record);
                    currentNode = currentNode.right;
                }
            }
        }
    }

}
