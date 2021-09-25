package dataStructures;

public interface IHashTable<K,V> {

	public V search(K key);
	public void add(K key, V value);
	public boolean delete(K key);

}
