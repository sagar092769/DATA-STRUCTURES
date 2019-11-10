package GRAPHS;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class graphs {
	private class vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, vertex> vtces = new HashMap<>();

	public int numVErtex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		vertex vtx = new vertex();
		this.vtces.put(vname, vtx);
	}

	public int numEdges() {
		int count = 0;
		for (String key : this.vtces.keySet()) {
			count += vtces.get(key).nbrs.size();
		}
		return count / 2;
	}

	public boolean containEdge(String vname1, String vname2) {
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void removeVertex(String vname) {
		vertex vtx = vtces.get(vname);
		for (String key : vtx.nbrs.keySet()) {
			vertex nbrvtx = vtces.get(key);
			nbrvtx.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}

	public void display() {
		System.out.println("-----------------------");

		ArrayList<String> key = new ArrayList<>(vtces.keySet());
		for (String keys : key) {
			System.out.println(keys + ":" + vtces.get(keys).nbrs);
		}
	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {
		processed.put(vname1, true);
		if (containEdge(vname1, vname2)) {
			return true;
		}
		vertex vtx = vtces.get(vname1);
		for (String nbr : vtx.nbrs.keySet()) {
			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)) {
				return true;
			}
		}
		return false;
	}

	public class Pair {
		String vname;
		String psf;
	}

	public boolean BFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair np = new Pair();
		np.vname = src;
		np.psf = src;
		queue.addLast(np);
		while (!queue.isEmpty()) {
			Pair rp = new Pair();
			rp = queue.removeFirst();
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);
			if (containEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			vertex rpvtx = vtces.get(rp.vname);
			for (String nbr : rpvtx.nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					Pair nnp = new Pair();
					nnp.vname = nbr;
					nnp.psf = rp.psf + nbr;
					queue.addLast(nnp);
				}
			}

		}
		return false;
	}

	public boolean dfs(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair np = new Pair();
		np.vname = src;
		np.psf = src;
		stack.addFirst(np);
		while (!stack.isEmpty()) {
			Pair rp = new Pair();
			rp = stack.removeFirst();
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);
			if (containEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			vertex rpvtx = vtces.get(rp.vname);
			for (String nbr : rpvtx.nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					Pair nnp = new Pair();
					nnp.vname = nbr;
					nnp.psf = rp.psf + nbr;
					stack.addFirst(nnp);
				}
			}

		}
		return false;
	}

	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = new Pair();
				rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				System.out.println(rp.vname + " " + "via " + rp.psf);

				vertex rpvtx = vtces.get(rp.vname);
				for (String nbr : rpvtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair nnp = new Pair();
						nnp.vname = nbr;
						nnp.psf = rp.psf + nbr;
						queue.addLast(nnp);
					}
				}
			}
		}
	}

	public void dft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			stack.addFirst(np);
			while (!stack.isEmpty()) {
				Pair rp = new Pair();
				rp = stack.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				System.out.println(rp.vname + " via " + rp.psf);

				vertex rpvtx = vtces.get(rp.vname);
				for (String nbr : rpvtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair nnp = new Pair();
						nnp.vname = nbr;
						nnp.psf = rp.psf + nbr;
						stack.addFirst(nnp);
					}
				}

			}

		}
	}

	public boolean isCyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				return true;
			}
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = new Pair();
				rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				System.out.println(rp.vname + " " + "via " + rp.psf);

				vertex rpvtx = vtces.get(rp.vname);
				for (String nbr : rpvtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair nnp = new Pair();
						nnp.vname = nbr;
						nnp.psf = rp.psf + nbr;
						queue.addLast(nnp);
					}
				}
			}
		}
		return false;
	}

	public boolean isConnected() {
		int count = 0;
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			count++;
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = new Pair();
				rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				vertex rpvtx = vtces.get(rp.vname);
				for (String nbr : rpvtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair nnp = new Pair();
						nnp.vname = nbr;
						nnp.psf = rp.psf + nbr;
						queue.addLast(nnp);
					}
				}

			}
		}
		return count == 1;
	}

	public ArrayList<ArrayList> getConnectedComponents() {
		ArrayList<ArrayList> fans = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			queue.addLast(np);
			ArrayList<String> subans = new ArrayList<>();
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				subans.add(rp.vname);
				for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair nnp = new Pair();
						nnp.vname = nbr;
						nnp.psf = rp.psf + nbr;
						queue.addLast(nnp);
					}
				}
			}
			fans.add(subans);
		}
		return fans;
	}

}
