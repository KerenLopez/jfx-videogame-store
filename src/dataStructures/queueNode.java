
package dataStructures;

public class queueNode <T> {
    
    private T person;
    private queueNode<T> lastPerson;

    public queueNode(T p) {
        p = person;
        lastPerson = null;
    }

    public queueNode<T> getLastPerson() {
        return lastPerson;
    }

    public void setLastPerson(queueNode<T> lp) {
        lp = lastPerson;
    }

    public T getPerson() {
        return person;
    }
    
}
