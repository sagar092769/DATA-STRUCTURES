package CU;

public class Stacksuinggenerics<T extends Object> {
	private int tos = -1;
	private T arr[];

	Stacksuinggenerics() {
		// TODO Auto-generated constructor stub
		this.tos = -1;
		this.arr = (T[]) new Object[5];
	}

	Stacksuinggenerics(int cap) {
		this.tos = -1;
		this.arr = (T[]) new Object[cap];
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == arr.length;
	}

	public void push(T item) {
		if (isFull()) {
			T data[] = (T[]) new Object[2 * arr.length];
			for (int i = 0; i < arr.length; i++) {
				data[i] = arr[i];
			}
			arr = data;
		}
		tos++;
		arr[tos] = item;

	}

	public T pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		T temp = arr[tos];
		tos--;
		return temp;
	}

	public T peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return arr[tos];
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
