package dataStructures;

public class Stack <T> implements IStack<T>{
	
	private NodeS<T> topNode;
	private int size;
	
	public Stack() {
		topNode = null;
		size = 0;
	}

	@Override
	public void push(T element) {
		NodeS<T> newNode = new NodeS<T>(element);
		size++;
		if(size>1) {
			newNode.setPrevious(topNode);
			topNode = newNode;
		}
	}

	@Override
	public T pop() {
		T savedElement = topNode.getElement();
		if(!isEmpty()) {
			savedElement = null;
		}else if(size==1){
			topNode = null;
			size--;
		}else {
			topNode = topNode.getPrevious();
			size--;
		}
		return savedElement;
	}

	@Override
	public T top() {
		T savedElement = topNode.getElement();
		if(isEmpty()) {
			savedElement = null;
		}
		return savedElement;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(size==0) {
			empty = true;
		}
		return empty;
	}

}
