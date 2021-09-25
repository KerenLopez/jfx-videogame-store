package dataStructures;

public class Queuee<T> implements QueueInterface<T>{
    
    private queueNode<T> frontPerson;
    private queueNode<T> backPerson;
    private int size;

    public Queuee() {
        frontPerson = null;
        backPerson = null;
        size=0;
    }
    
    @Override
    public void enqueue(T person) {
        if(isEmpty()) {
            frontPerson = new queueNode<>(person);
            backPerson = frontPerson;
        }
        else {
            queueNode<T> currentPerson = frontPerson;
            while(currentPerson.getLastPerson()!=null) {
                    currentPerson = currentPerson.getLastPerson();
            }
            currentPerson.setLastPerson(new queueNode<>(person));
            backPerson = currentPerson.getLastPerson();
        }
        size++;
    }

    @Override
    public T dequeue() {
        T personOutsideQueue = frontPerson.getPerson();
        frontPerson = frontPerson.getLastPerson();
        size--;
        return personOutsideQueue;
    }

    @Override
    public T front() {
        return frontPerson.getPerson();
    }

    @Override
    public boolean isEmpty() {
        return frontPerson==null;
    }
    
}
