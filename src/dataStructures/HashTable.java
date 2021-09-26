package dataStructures;

import java.util.ArrayList;

public class HashTable<K,V> implements IHashTable<K,V> {
	private int size;
	private int maxSize;
	private Slot<K,V>[] hashTable;

	@SuppressWarnings("unchecked")
	public HashTable(int s) {
		maxSize=s;
		size=0;
		hashTable=(Slot<K,V>[])(new Slot[maxSize]);
	}

	public int getMaxSize() {
		return maxSize;
	}

	public boolean slotsAvailable() {
		boolean available=false;
		if(size<maxSize) {
			available=true;
		}
		return available;
	}
	

	@Override
	public V search(K key) {
		V searched=null;
		int i=0;

		int hf= key.hashCode()%maxSize;

		do {
			int h=h(i,hf);
			
			if(hashTable[h]!=null && hashTable[h].getKey().equals(key)) {
				searched=hashTable[h].getValue();
				i=Integer.MAX_VALUE;

			}else {
				if(hashTable[h]!=null) {
					i++;
				}else {
					i=Integer.MAX_VALUE;
				}

				
			}
		}while(i<maxSize);

		return searched;
	}

	@Override
	public void add(K key, V value) {
		int i=0;
		
		int hf= key.hashCode()%maxSize;
		do {
			int h=h(i,hf);

			if(hashTable[h]==null) {
				hashTable[h]= new Slot<>(key,value);
				i=Integer.MAX_VALUE;
				size++;

			}else {
				i++;
			}
		}while(i<maxSize);

	}

	@Override
	public boolean delete(K key) {
		boolean deleted=false;
		int i=0;
	
		int hf= key.hashCode()%maxSize;


		do {
			int h=h(i,hf);

			if(hashTable[h]!=null && hashTable[h].getKey().equals(key)) {
				hashTable[h]=null;
				deleted=true;
				size--;
			}else {
				if(hashTable[h]!=null) {
					i++;
				}else {
					i=Integer.MAX_VALUE;
				}
			}
		}while(i<maxSize && !deleted);


		return deleted;
	}


	private int h(int i, int hf) {
		int hn=0;
		hn=(hf+i)%maxSize;
		return hn;
	}

	@Override
	public void replace(K key, V value) {
		int i=0;
	
		int hf= key.hashCode()%maxSize;
		
		do {
			int h=h(i,hf);
			if(hashTable[h]!=null && hashTable[h].getKey().equals(key)) {
				hashTable[h].setValue(value);
				i=Integer.MAX_VALUE;
			}else {
				if(hashTable[h]!=null) {
					i++;
				}else {
					i=Integer.MAX_VALUE;
				}
			}
		}while(i<maxSize);

	}
	
	@Override
	public ArrayList<V> elements(){
		ArrayList<V> elem=new ArrayList<>();
		for(int i=0; i<maxSize;i++) {
			if(hashTable[i]!=null) {
				elem.add(hashTable[i].getValue());
			}
		}
		return elem;
	}
}