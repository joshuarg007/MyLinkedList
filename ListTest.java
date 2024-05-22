// Importing necessary classes
import java.util.Iterator; // Import for using Iterator
import java.util.Scanner; // Import for user input

// Class definition for ListTest
public class ListTest {
    // Main method
    public static void main(String[] args) {
        // Creating an instance of MyLinkedList
        MyLinkedList linkedList = new MyLinkedList();
        // Creating a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Flag to control the loop
        boolean exit = false;

        // Loop until exit command is given
        while (!exit) {
            // Displaying menu options
            System.out.println("Choose an option:");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Display elements");
            System.out.println("4. Read elements from a file");
            System.out.println("5. Exit");
            // Reading user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Performing actions based on user's choice
            switch (choice) {
                case 1:
                    // Insert an element
                    System.out.println("Enter the element to insert:");
                    int dataToInsert = scanner.nextInt();
                    linkedList.insert(dataToInsert);
                    break;
                case 2:
                    // Delete an element
                    System.out.println("Enter the element to delete:");
                    int dataToDelete = scanner.nextInt();
                    linkedList.delete(dataToDelete);
                    break;
                case 3:
                    // Display elements
                    System.out.println("Elements in the linked list:");
                    displayElements(linkedList);
                    break;
                case 4:
                    // Read elements from a file
                    System.out.println("Enter the file name:");
                    String fileName = scanner.next();
                    linkedList.insertFromFile(fileName);
                    break;
                case 5:
                    // Exit the loop
                    exit = true;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice!");
            }
        }

        // Closing the scanner
        scanner.close();
    }

    // Method to display elements using custom iterator
    private static void displayElements(MyLinkedList linkedList) {

        // Obtaining an iterator for the linked list
        Iterator<Integer> iterator = linkedList.iterator();

        // Iterating over the elements using the iterator
        while (iterator.hasNext()) 
            // Printing the next element followed by a space
            System.out.print(iterator.next() + " ");
        

        // Printing a new line after printing all elements
        System.out.println();
    }

}
