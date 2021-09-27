
package dataStructures;

public class QueueNode <T> {
    
    private T element;
    private QueueNode<T> lastElement;

    public QueueNode(T e) {
        element=e;
        lastElement = null;
    }

    public QueueNode<T> getLastElement() {
        return lastElement;
    }

    public void setLastElement(QueueNode<T> le) {
        lastElement=le;
    }

    public T getElement() {
        return element;
    }
}
