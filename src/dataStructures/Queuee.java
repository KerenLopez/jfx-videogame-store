package dataStructures;

public class Queuee<T> implements QueueInterface<T>{
    
    private QueueNode<T> front;
    private QueueNode<T> back;
    private int size;

    public Queuee() {
        front = null;
        back = null;
        size=0;
    }
    
    @Override
    public void enqueue(T element) {
        if(isEmpty()) {
            front = new QueueNode<>(element);
            back = front;
        }
        else {
            QueueNode<T> current = front;
            while(current.getLastElement()!=null) {
                    current= current.getLastElement();
            }
            current.setLastElement(new QueueNode<>(element));
            back = current.getLastElement();
        }
        size++;
    }

    @Override
    public T dequeue() {
        T outsideQueue = front.getElement();
        front = front.getLastElement();
        size--;
        return outsideQueue;
    }

    @Override
    public T front() {
        return front.getElement();
    }
    
    @Override
    public T back() {
        return back.getElement();
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }
}
