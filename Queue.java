package CU;

public class Queue<T extends Object> {
	private T[] data;
	private int size;
	private int front;

	public Queue() {
		data = (T[]) new Object[5];
		size = 0;
		front = 0;
	}

	public Queue(int cap) {
		data = (T[]) new Object[cap];
		size = 0;
		front = 0;
	}

	public void enqueue(T item) throws Exception {

		if (isFull()) {
			throw new Exception("Queue is Full.");
		}

		int idx = (front + size) % data.length;
		data[idx] = item;

		size++;
	}

	public T dequeue() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is Empty.");
		}

		T rv = data[front];
		front = (front + 1) % data.length;
		size--;
		return rv;

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == data.length;
	}

	public void display() {

		for (int i = 0; i < size; i++) {
			int idx = (i + front) % data.length;
			System.out.print(data[idx] + " ");
		}
		System.out.println();

	}

}
