package HEAP;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap hp=new Heap();
		hp.addItem(10);
		hp.display();
		hp.addItem(20);
		hp.display();
		hp.addItem(30);
		hp.display();
		hp.addItem(40);
		hp.display();
		hp.addItem(50);
		hp.display();
		hp.addItem(5);
		hp.display();
		hp.addItem(3);
		hp.display();
		hp.remove();
		hp.display();

	}

}
