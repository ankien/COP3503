/*  Andrew Kien
 *  This program adds the numbers 1-20 in a queue, then removes them.
 *  It display the numbers in the queue as they're being removed.
 */

public class TestQueueKien {
	
	public static void main(String[] args) {

		// Stage 1: Creates a queue with an initial capacity of 8.
		QueueKien queue = new QueueKien(8);
		
		// Stage 2: Calls enqueue to fill the queue with integers 1-20.
		for(int i = 1; i <= 20; i++) {
			queue.enqueue(i);
		}
		
		// Stage 3: Print out the full queue.
		System.out.println("Initial Queue contents :  (Queue Size = " + queue.getSize() + ")");
		for(int i = 0; i < queue.getSize(); i++) {
			System.out.print(" " + queue.printQueue(i));
		}
		
		// Stage 4: Dequeue the queue repeatedly, displays the queue for every fifth number removed.
		while(queue.empty() != true) {
			for (int i = 0; i < 5; i++) {
				queue.dequeue();
			}
			
			if(queue.getSize() == 0)
				System.exit(0);
			
			System.out.println("\nQueue contents after removing 5 elements :  (Queue Size = " + queue.getSize() + ")");
			for(int i = 0; i < queue.getSize(); i++) {
				System.out.print(" " + queue.printQueue(i));
			}
		}
	}
}

class QueueKien {
	
	private int[] elements;
	private int size;
	
	public QueueKien() {
		this(0);
	}
	
	public QueueKien(int capacity) {
		elements = new int[capacity];
	}
	
	/*  Inserts an integer into the front of the queue.
	 *  Doubles the size of the queue when the elements exceed the size.
	 */
	public void enqueue(int v) {
		if(size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = v;
	}
	
	/*  Removes element at the front of the queue.
	 *  Returns the following element.
	 */
	public int dequeue() {
		System.arraycopy(elements, 1, elements, 0, elements.length - 1);
		this.size--;
		return elements[0];
	}
	
	/*  Checks if the queue is empty.
	 *  Returns False if otherwise
	 */
	public boolean empty() {
		return size == 0;
	}
	
	/*  Obtains the size of the queue.
	 *  Returns an integer
	 */
	public int getSize() {
		return size;
	}
	
	/*  Used to print out each element.
	 *  Returns the element at specified index.
	 */
	public int printQueue(int index) {
		return elements[index];
	}
}