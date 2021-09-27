
package dataStructures;

public class QueueNode <T> {
    
    private T person;
    private QueueNode<T> lastPerson;

    public QueueNode(T p) {
        p = person;
        lastPerson = null;
    }

    public QueueNode<T> getLastPerson() {
        return lastPerson;
    }

    public void setLastPerson(QueueNode<T> lp) {
        lp = lastPerson;
    }

    public T getPerson() {
        return person;
    }
    
}
