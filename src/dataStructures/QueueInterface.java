
package dataStructures;

public interface QueueInterface<T>{
	public void enqueue(T person);
        public T dequeue();
        public T front();
	public boolean isEmpty();
}
