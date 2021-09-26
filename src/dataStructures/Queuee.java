package dataStructures;

public class Queuee<T> implements QueueInterface<T>{
    
    private QueueNode<T> frontPerson;
    private QueueNode<T> backPerson;
    private int size;

    public Queuee() {
        frontPerson = null;
        backPerson = null;
        size=0;
    }
    
    @Override
    public void enqueue(T person) {
        if(isEmpty()) {
            frontPerson = new QueueNode<>(person);
            backPerson = frontPerson;
        }
        else {
            QueueNode<T> currentPerson = frontPerson;
            while(currentPerson.getLastPerson()!=null) {
                    currentPerson = currentPerson.getLastPerson();
            }
            currentPerson.setLastPerson(new QueueNode<>(person));
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
