package avlTree;

import org.apache.commons.csv.CSVRecord;

public class Node {
    CSVRecord record;
    Node left, right;
    int height;

    Node(CSVRecord record) {
        this.record = record;
        height = 1;
    }
}