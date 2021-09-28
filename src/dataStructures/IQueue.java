
package dataStructures;

public interface IQueue<T>{
	public void enqueue(T person);
        public T dequeue();
        public T front();
        public T back();
	public boolean isEmpty();
}
