package dataStructures;

import java.util.ArrayList;

public class HashTable<K,V> implements IHashTable<K,V> {
	private int size;
	private ArrayList<Slot<K,V>> hashTable;

	public HashTable(int s) {
		size=s;
		hashTable=new ArrayList<>(size);
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public V search(K key) {
		V searched=null;
		int i=0;
		int hf=hFunction(key);

		int h=h(i,hf);
		do {
			if(hashTable.get(h)!=null && hashTable.get(h).getKey()==key) {
				searched=hashTable.get(h).getValue();
			}else {
				i++;
			}
		}while(i<size && searched==null);

		return searched;
	}

	@Override
	public void add(K key, V value) {
		int i=0;
		int hf=hFunction(key);
		do {
			int h=h(i,hf);
			if(hashTable.get(h)==null) {
				hashTable.add(h, new Slot<>(key,value));
				i=Integer.MAX_VALUE;

			}else {
				i++;
			}
		}while(i<size);

	}

	@Override
	public boolean delete(K key) {
		boolean deleted=false;
		int i=0;
		int hf=hFunction(key);

		int h=h(i,hf);
		do {
			if(hashTable.get(h)!=null && hashTable.get(h).getKey()==key) {
				hashTable.set(h,null);
				deleted=true;
			}else {
				i++;
			}
		}while(i<size && !deleted);

		
		return deleted;
	}


	public int h(int i, int hf) {
		int hn=0;
		hn=(hf+i)%size;
		return hn;
	}

	public int hFunction(K key) {
		String str= String.valueOf(key);

		int hf=0;
		for(int j=0; j<str.length();j++) {
			char c=str.charAt(j);
			hf+=Character.getNumericValue(c)*(str.length()-1-j);
		}

		hf=hf%size;

		return hf;
	}

	@Override
	public void replace(K key, V value) {
		int i=0;
		int hf=hFunction(key);

		int h=h(i,hf);
		do {
			if(hashTable.get(h)!=null && hashTable.get(h).getKey()==key) {
				hashTable.get(h).setValue(value);
				i=Integer.MAX_VALUE;
			}else {
				i++;
			}
		}while(i<size);
		
	}
}
