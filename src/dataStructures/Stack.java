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
		if(!isEmpty()) {
			newNode.setPrevious(topNode);
		}
		topNode = newNode;
		size++;
	}

	@Override
	public T pop() {
		T savedElement = null;
		if(size==1){
			savedElement = topNode.getElement();
			topNode = null;
			size--;
		}else if(size>1){
			savedElement = topNode.getElement();
			topNode = topNode.getPrevious();
			size--;
		}
		return savedElement;
	}

	@Override
	public T top() {
		T savedElement = null;
		if(!isEmpty()) {
			savedElement = topNode.getElement();
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

	public int getSize() {
		return size;
	}
}
