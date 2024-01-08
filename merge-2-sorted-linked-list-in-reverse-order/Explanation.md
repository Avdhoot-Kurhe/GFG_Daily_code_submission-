# Linked List Merge Explanation

## MainClass
```java
import java.util.*;
import java.io.*;

// Define the Node class representing a node in a linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        // Iterate through each test case
        while (t-- > 0) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            // Initialize linked list 1
            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }

            // Initialize linked list 2
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }

            // Create an instance of GfG class
            GfG gfg = new GfG();
            
            // Merge the two linked lists in non-increasing order
            Node result = gfg.mergeResult(node1, node2);

            // Print the merged list
            printList(result);
        }
    }

    // Helper method to print the linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
```