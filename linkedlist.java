package CU;

public class linkedlist {
	public class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (!isEmpty())
			tail.next = nn;

		// data members
		if (isEmpty()) {
			head = nn;
			tail = nn;
			size++;
		} else {
			tail = nn;
			size++;
		}

	}

	public void addFirst(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = head;

		// data members
		if (isEmpty()) {
			head = nn;
			tail = nn;
			size++;
		} else {
			head = nn;
			size++;
		}

	}

	public void display() {

		System.out.println("--------------------");
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
		System.out.println("--------------------");
	}

	public void removeLast() {
		Node nod = head;
		while (nod.next.next != null) {
			nod = nod.next;
		}
		nod.next = null;
		size--;

	}

	public void removeFirst() {
		head = head.next;
		size--;
	}

}
