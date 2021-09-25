package dataStructures;

public class NodeS<T> {
	
	private T element;
	private NodeS<T> previous;
	
	public NodeS(T e) {
		element = e;
		previous = null;
	}

	public NodeS<T> getPrevious() {
		return previous;
	}

	public void setPrevious(NodeS<T> previous) {
		this.previous = previous;
	}

	public T getElement() {
		return element;
	}
}
