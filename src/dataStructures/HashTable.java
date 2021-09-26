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
	public K searchKey(K key) {
		K searched=null;
		int i=0;

		int hf= key.hashCode()%maxSize;
	
		do {
			int h=h(i,hf);
			
			if(hashTable[h]!=null && hashTable[h].getKey()==key) {
				searched=hashTable[h].getKey();
				i=Integer.MAX_VALUE;
			}else {

				i++;
			}
		}while(i<maxSize);

		return searched;
	}

	@Override
	public V search(K key) {
		V searched=null;
		int i=0;
		//	int hf=hFunction(key);
		int hf= key.hashCode()%maxSize;
		System.out.println(hf+"hf");

		do {
			int h=h(i,hf);
			System.out.println(h+"h");
			System.out.println(hf+"hf2");
			System.out.println(i+"i");
			if(hashTable[h]!=null && hashTable[h].getKey()==key) {
				searched=hashTable[h].getValue();
				i=Integer.MAX_VALUE;

			}else {
				System.out.println("aloooo");

				i++;
			}
		}while(i<maxSize);

		return searched;
	}

	@Override
	public void add(K key, V value) {
		int i=0;
		//int hf=hFunction(key);
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
		//int hf=hFunction(key);
		int hf= key.hashCode()%maxSize;


		do {
			int h=h(i,hf);

			if(hashTable[h]!=null && hashTable[h].getKey()==key) {
				hashTable[h]=null;
				deleted=true;
				size--;
			}else {
				i++;
			}
		}while(i<maxSize && !deleted);


		return deleted;
	}


	public int h(int i, int hf) {
		int hn=0;
		hn=(hf+i)%maxSize;
		return hn;
	}
	/*
	public int hFunction(K key) {
		String str= String.valueOf(key);

		int hf=0;
		for(int j=0; j<str.length();j++) {
			char c=str.charAt(j);
			System.out.println(Character.getNumericValue(c)+"char");
			System.out.println(Math.pow(128, str.length()-1-j));
			hf+=(Character.getNumericValue(c))*(Math.pow(128, str.length()-1-j));
			System.out.println(hf);

		}
		hf=hf%maxSize;
		System.out.println(hf+"mod");

		return hf;
	}
	 */
	@Override
	public void replace(K key, V value) {
		int i=0;
		//int hf=hFunction(key);
		int hf= key.hashCode()%maxSize;
		int h=h(i,hf);
		do {
			if(hashTable[h]!=null && hashTable[h].getKey()==key) {
				hashTable[h].setValue(value);
				i=Integer.MAX_VALUE;
			}else {
				i++;
			}
		}while(i<maxSize);

	}

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