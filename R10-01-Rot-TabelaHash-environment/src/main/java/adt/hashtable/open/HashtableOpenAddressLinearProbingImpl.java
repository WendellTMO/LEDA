package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
			int probing = 0;
			int key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
			boolean insert = false;

			while (probing <= table.length && insert == false) {
				if (table[key] == null || table[key].equals(new DELETED())) {
					table[key] = element;
					insert = true;
					elements++;
				} else {
					probing++;
					key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
					COLLISIONS++;
				}
			}

		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probing = 0;
			int key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
			boolean remove = false;
			
			while (probing <= table.length && remove == false) {
				if (table[key] == null) {
					remove = true;
				} else if (table[key].equals(element)) {
					table[key] = new DELETED();
					elements--;
					remove = true;
				} else {
					probing++;
					key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
				}
			}

		}

	}

	@Override
	public T search(T element) {
		T res = null;
		if (element != null) {
			int probing = 0;
			int key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
			boolean search = false;

			while (probing <= table.length  && search == false) {
				if (table[key] == null) {
					search = true;
				} else if (table[key].equals(element)) {
					res = element;
					search = true;
				} else {
					probing++;
					key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
				}
			}
		}
		return res;
	}

	@Override
	public int indexOf(T element) {
		int res = -1;
		if (element != null) {
			int probing = 0;
			int key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
			boolean find = false;

			while (probing <= table.length && find == false) {
				if (table[key] != null && table[key].equals(element)) {
					find = true;
					res = key;
				} else {
					probing++;
					key = ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probing);
				}
			}
		}
		return res;
	}

}
