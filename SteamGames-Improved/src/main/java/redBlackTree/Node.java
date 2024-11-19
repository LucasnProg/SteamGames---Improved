package redBlackTree;

import org.apache.commons.csv.CSVRecord;

public class Node {
    CSVRecord record;
    Node left, right;
    boolean isRed;

    public Node(CSVRecord record, boolean isRed) {
        this.record = record;
        this.isRed = isRed;
        left = right = null;
    }
}
