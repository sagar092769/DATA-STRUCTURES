package CU;

public class StacksusinggenericsClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stacksuinggenerics<Integer> st=new Stacksuinggenerics<>();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		System.out.println(st.isFull());
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
	    st.push(6);
		System.out.println(st.size());
		st.display();
		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st.size());
		Stacksuinggenerics<String> sw=new Stacksuinggenerics<>();
		sw.push("a");
		sw.push("b");
		sw.push("c");
		sw.push("d");
		sw.push("e");
		sw.display();
		

	}

}
