package dataStructures;

public interface IStack <T>{
	public void push(T element);
	public T pop();
	public T top();
	public boolean isEmpty();
}
