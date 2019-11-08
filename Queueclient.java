package CU;

public class Queueclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue<Integer> qe=new Queue<>();
		qe.enqueue(1);
		qe.enqueue(2);
		qe.enqueue(3);
		qe.enqueue(4);
		qe.enqueue(5);
		qe.display();
		System.out.println(qe.isEmpty());
		System.out.println(qe.isFull());
		System.out.println(qe.size());
		System.out.println(qe.dequeue());
		System.out.println(qe.size());

	}

}
