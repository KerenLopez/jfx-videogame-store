
package dataStructures;

public class NodeQ <T> {
    
    private T element;
    private NodeQ<T> lastElement;

    public NodeQ(T e) {
        element=e;
        lastElement = null;
    }

    public NodeQ<T> getLastElement() {
        return lastElement;
    }

    public void setLastElement(NodeQ<T> le) {
        lastElement=le;
    }

    public T getElement() {
        return element;
    }
}
