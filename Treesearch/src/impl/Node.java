package impl;

import java.util.LinkedList;
import java.util.List;

public class Node {
	private Node parrent;
	private String id;

	public Node getParrent() {
		return parrent;
	}

	public void setParrent(Node parrent) {
		this.parrent = parrent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String rootID = "THIS";
		if (this.parrent != null) {
			rootID = this.getRoot().getId();
		}
		return "Node [root=" + rootID + ", id=" + id + "]";
	}

	public Node(String id) {
		this.id = id;
		this.parrent = null;
	}

	public Node getRoot() {
		return this.getRoot(new LinkedList<String>());
	}

	private Node getRoot(List<String> searchPath) {
		if (this.parrent == null) {
			return this;
		} else {
			if (searchPath.contains(this.id)) {
				return this;
			} else {
				searchPath.add(this.id);
				return this.parrent.getRoot(searchPath);
			}
		}
	}

}
