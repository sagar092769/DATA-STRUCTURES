package HEAP;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> list = new ArrayList<>();

	public void addItem(int item) {
		this.list.add(item);
		upheapify(this.list.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (this.list.get(ci) < this.list.get(pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private void swap(int i, int j) {
		int ith = this.list.get(i);
		int jth = this.list.get(j);
		this.list.set(i, jth);
		this.list.set(j, ith);
	}

	public void display() {
		System.out.println(this.list);
	}

	public int get() {
		return this.list.get(0);
	}

	public int remove() {
		swap(0, this.list.size() - 1);
		int re = this.list.remove(list.size() - 1);
		downheapify(0);
		return re;
	}

	private void downheapify(int pi) {
		int lci = (2 * pi) + 1;
		int rci = (2 * pi) + 2;
		int mini = pi;
		if (lci < list.size() && this.list.get(lci) < this.list.get(pi)) {
			mini = lci;
		}
		if (rci < list.size() && this.list.get(rci) < this.list.get(pi)) {
			mini = rci;
		}
		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}

}
