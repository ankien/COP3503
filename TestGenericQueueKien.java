import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

/*  Andrew Kien
 *  This program reads two files, each filled with names or numbers
 *  It stores this data in two seperate queues and prints out the queue for each 5 elements removed.
 */

public class TestGenericQueueKien {

	public static void main(String[] args) {
		
		// Stage 1: Creates a queue of Strings for people.dat.
		GenericQueueKien<String> queue1 = new GenericQueueKien<String>();
		
		// Stage 2: Reads from people.dat, then populates queue1.
		try {
			File    file = new File("people.dat");
			Scanner read = new Scanner(file);
			
			while(read.hasNextLine()) {
				queue1.enqueue(read.next());
			}	
			read.close();
		}
		catch (Exception ex) {
			System.out.println("Error reading files! Ensure .dat files are in project directory and run again.");
			ex.printStackTrace();
		}

		// Stage 3: Display queue1; dequeue queue1 repeatedly and display the queue for every fifth element removed.
		System.out.println("Initial Queue contents");
		for(int i = 0; i < queue1.getSize(); i++) {
			System.out.print(queue1.printQueue(i) + " ");
		}
		
		while(!queue1.empty()) {
			for(int i = 0; i < 5; i++) {
				queue1.dequeue();
			}
			
			System.out.println();
			if(queue1.getSize() != 0) {
				System.out.println("The queue contents after removing 5 elements:");
				for(int i = 0; i < queue1.getSize(); i++) {
					System.out.print(queue1.printQueue(i) + " ");
				}
			}
		}
		// Stage 4: Creates a queue of integers for numbers.dat.
		GenericQueueKien<Integer> queue2 = new GenericQueueKien<Integer>();
		
		// Stage 5: Reads from numbers.dat, then populates queue2.
		try {
			File    file = new File("numbers.dat");
			Scanner read = new Scanner(file);
			
			while(read.hasNextLine()) {
				queue2.enqueue(read.nextInt());
			}
			
			read.close();
		}
		catch (Exception ex) {
			System.out.println("Error reading files! Ensure .dat files are in project directory and run again.");
			ex.printStackTrace();
		}
		
		// Stage 6: Display queue2; dequeue queue2 repeatedly and display the queue for every fifth element removed.
		System.out.println("Initial Queue contents");
		for(int i = 0; i < queue2.getSize(); i++) {
			System.out.print(queue2.printQueue(i) + " ");
		}
		
		while(!queue2.empty()) {
			for(int i = 0; i < 5; i++) {
				queue2.dequeue();
			}
			
			System.out.println();
			if(queue2.getSize() != 0) {
				System.out.println("The queue contents after removing 5 elements:");
				for(int i = 0; i < queue2.getSize(); i++) {
					System.out.print(queue2.printQueue(i) + " ");
				}
			}
		}
	}

}

class GenericQueueKien<E> extends ArrayList<E> {
	
	/*  Inserts an element into the front of the queue.
	 *  Doubles the size of the queue when the elements exceed the size.
	 */
	public void enqueue(E v) {
		add(v);
	}
	
	/*  Removes element at the front of the queue.
	 *  Returns that element
	 */
	public E dequeue() {
		E elementRemoved = get(0);
		remove(0);
		return elementRemoved;
	}
	
	/*  Checks if the queue is empty.
	 *  Returns False if otherwise
	 */
	public boolean empty() {
		return isEmpty();
	}
	
	/*  Obtains the size of the queue.
	 *  Returns an integer
	 */
	public int getSize() {
		return size();
	}
	
	/*  Used to print out each element.
	 *  Returns the element at specified index.
	 */
	public E printQueue(int index) {
		E temp = get(index); 
		return temp;
	}
}
