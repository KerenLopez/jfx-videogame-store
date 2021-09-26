package dataStructures;

import java.util.ArrayList;

public interface IHashTable<K,V> {

	public V search(K key);
	public void add(K key, V value);
	public boolean delete(K key);
	public void replace(K key, V value);
	public ArrayList<V> elements();

}
