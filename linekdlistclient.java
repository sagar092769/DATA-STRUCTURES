package CU;

public class linekdlistclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedlist list=new linkedlist();
		list.addFirst(10);
		list.addFirst(20);
		list.addLast(30);
		list.addLast(10);
		list.display();
		list.removeLast();
		list.display();
		list.removeFirst();
		list.display();

	}

}
