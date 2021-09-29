package dataStructures;

public class Slot<K,V> {
	private K key;
	private V value;
	
	public Slot(K k, V v) {
		key=k;
		value=v;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V v) {
		value=v;
	}
	
	
}
