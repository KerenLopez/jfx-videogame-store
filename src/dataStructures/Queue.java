package dataStructures;

public class Queue<T> implements IQueue<T>{
    
    private NodeQ<T> front;
    private NodeQ<T> back;
    private int size;

    public Queue() {
        front = null;
        back = null;
        size=0;
    }
    
    @Override
    public void enqueue(T element) {
        if(isEmpty()) {
            front = new NodeQ<>(element);
            back = front;
        }
        else {
            NodeQ<T> current = front;
            while(current.getLastElement()!=null) {
                    current= current.getLastElement();
            }
            current.setLastElement(new NodeQ<>(element));
            back = current.getLastElement();
        }
        size++;
    }

    @Override
    public T dequeue() {
        T outsideQueue = null;
        if(!isEmpty()){
            outsideQueue = front.getElement();
            front = front.getLastElement();
            size--;
        }
        return outsideQueue;
    }

    @Override
    public T front() {
        T element=null;
        if(!isEmpty()) {
            element = front.getElement();
        }
        return element;
    }
    
    @Override
    public T back() {
        T element=null;
        if(!isEmpty()) {
            element = back.getElement();
        }
        return element;
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
