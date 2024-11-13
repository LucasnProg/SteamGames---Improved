package avlTree;

import org.apache.commons.csv.CSVRecord;

public  class Node {
    CSVRecord record;
    Node left, right;
    int height;

    public Node(CSVRecord record) {
        this.record = record;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}