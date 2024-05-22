import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList {
    private Node head;

    // Method to insert a new node with the given data
    public void insert(int data) {

        Node newNode = new Node(data); // Create new node

        if (head != null)  // Check if list is eempty
        
            newNode.next = head;// If empty, set head as a new node with data 

        head = newNode;
    }

    // Method to delete the first occurrence of a node with the given data
    public void delete(int data) {

        if (head == null) // if list is empty
            return; // exit method
        

        if (head.data == data) { // if the data to delete is at the head
            head = head.next; // assign as next node in list
            return; // exit method
        }

        Node current = head; // Begin iteration at head

        while (current.next != null) { // while there is a next node
            // if the next node contains the item to search for
            if (current.next.data == data) { 
                current.next = current.next.next; // cut current node out of linkedList
                return; // exit method
            }

            current = current.next; // data not found, check next node
        }
    }

    // Method to insert elements from a file
    public void insertFromFile(String fileName) {

        // try-catch to catch exceptions
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // Variable to store each line read from the file
            String line;

            // Loop to read each line from the file 
            while ((line = br.readLine()) != null) {

                // Split the line into individual elements
                String[] elements = line.split("\\s+"); // Split by whitespace
                
                // Loop over each element extracted from the line
                for (String element : elements) {

                    // Parse each element as an integer
                    int data = Integer.parseInt(element);

                    // Insert the parsed integer into the list
                    insert(data);
                }
            }
        // Catch IOException
        } catch (IOException e) {
            // Printing stack trace on error
            e.printStackTrace();
        }
    }


    // Method to return an iterator for traversing the linked list
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Inner class representing a node in the linked list
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Inner class representing the iterator for the linked list
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }

 }
