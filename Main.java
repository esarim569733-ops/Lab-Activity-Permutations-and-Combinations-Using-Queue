package CCE105;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
 
 
public class Main {
 
 
    static Scanner input = new Scanner(System.in);
 
 
    // Queue implementation
    static Queue<String> queue = new LinkedList<>();
 
 
    public static void main(String[] args) {
 
 
        int choice;
 
 
        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");
 
 
            choice = input.nextInt();
 
 
            switch (choice) {
 
 
                case 1:
                    addElements();
                    break;
 
 
                case 2:
                    displayQueue();
                    break;
 
 
                case 3:
                    generatePermutations();
                    break;
 
 
                case 4:
                    generateCombinations();
                    break;
 
 
                case 5:
                    System.out.println("Program terminated.");
                    break;
 
 
                default:
                    System.out.println("Invalid choice!");
            }
 
 
        } while (choice != 5);
    }
 
 
    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {
    	System.out.println("How many elements to add?");
    	int num = input.nextInt();
    	input.nextLine();
    	
    	
    	for (int i = 0; i < num; i++) {
    		System.out.println("Enter element");
        	String ele = input.nextLine();
    		queue.add(ele);
    		
    	}
 
 
    }
    // Ask how many elements to add
    // Use queue.add() to insert elements
 
 
    // TODO 2: Display all elements in the Queue
    static void displayQueue() {
    	if (queue.isEmpty()) {
    		System.out.println("Queue is empty.");
    	} else {
    		System.out.println(queue);
    	}
 
 
        // Display the contents of the Queue
 
 
    }
 
 
    // TODO 3: Generate all possible permutations
    static void generatePermutations() {
    	if (queue.isEmpty()) {
    		System.out.println("Queue is empty. Add elements first.");
    		return;
    	}
    	
    	System.out.println("How many elements should be selected? ");
    	int num = input.nextInt();
    	input.nextLine();
    	
    	ArrayList<String> list = new ArrayList<>(queue);
    	
    	if (num < 1 || num > list.size()) {
    		System.out.println("Invalid number.");
    		return;
    	}
    	
    	System.out.println("Permutations:");
    	int total = permute(list, "", 0, num);
    	System.out.println("Total permutations: " + total);
 
 
        // Ask how many elements should be selected (r)
        // Generate all possible arrangements
        // Display the total number of permutations
 
 
    }
    
    // Recursive helper for permutations
    static int permute(ArrayList<String> list, String current, int picked, int r) {
    	if (picked == r) {
    		System.out.println(current);
    		return 1;
    	}
    	
    	int count = 0;
    	for (int i = 0; i < list.size(); i++) {
    		String item = list.remove(i);
    		count += permute(list, current.isEmpty() ? item : current + "," + item, picked + 1, r);
    		list.add(i, item);
    	}
    	return count;
    }
 
 
    // TODO 4: Generate all possible combinations
    static void generateCombinations() {
    	if (queue.isEmpty()) {
    		System.out.println("Queue is empty. Add elements first.");
    		return;
    	}
    	
    	System.out.println("How many elements should be selected? ");
    	int num = input.nextInt();
    	input.nextLine();
    	
    	ArrayList<String> list = new ArrayList<>(queue);
    	
    	if (num < 1 || num > list.size()) {
    		System.out.println("Invalid number.");
    		return;
    	}
    	
    	System.out.println("Combinations:");
    	int total = combine(list, "", 0, 0, num);
    	System.out.println("Total combinations: " + total);
 
 
        // Ask how many elements should be selected (r)
        // Generate all possible selections
        // Avoid duplicate combinations
        // Display the total number of combinations
 
 
    }
    
    
    static int combine(ArrayList<String> list, String current, int start, int picked, int r) {
    	if (picked == r) {
    		System.out.println(current);
    		return 1;
    	}
    	
    	int count = 0;
    	for (int i = start; i < list.size(); i++) {
    		count += combine(list, current.isEmpty() ? list.get(i) : current + "," + list.get(i), i + 1, picked + 1, r);
    	}
    	return count;
    }
}
