package binarySearchTree;

import org.apache.commons.csv.CSVRecord;

class Node {
    CSVRecord record;
    Node left, right;

    public Node(CSVRecord record) {
        this.record = record;
        left = right = null;
    }
}
