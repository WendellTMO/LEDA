package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) {
			throw new HashtableOverflowException();
		}

		if (element != null && search(element) != element) {
			int probing = 0;
			int key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
			boolean stop = false;
			
			while (probing <= table.length && stop == false) {
				if (table[key] == null || table[key].equals(new DELETED())) {
					table[key] = element;
					elements++;
					stop = true;
				} else {
					probing++;
					key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
					COLLISIONS++;
				}
			}

		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probing = 0;
			int key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
			boolean stop = false;
			
			try {
				while (stop == false) {
					if (table[key] == null) {
						stop = true;
					} else if (table[key].equals(element)) {
						table[key] = new DELETED();
						stop = true;
						elements--;
					} else {
						probing++;
						key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
					}
				}
			} catch (RuntimeException e) {
				throw new HashtableOverflowException();
			}
		}
	}

	@Override
	public T search(T element) {
		T res = null;
		if (element != null) {
			int probing = 0;
			int key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
			boolean stop = false; 

			while (probing < table.length && stop == false) {
				if (table[key] == null) {
					stop = true;
				} else if (table[key].equals(element)) {
					res = element;
					stop = true;
				} else {
					probing++;
					key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
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
			int key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
			boolean stop = false;

			while (probing < table.length && stop == false) {
				if (table[key] == null) {
					stop = true;
				} else if (table[key].equals(element)) {
					res = key;
					stop = true;
				} else {
					probing++;
					key = ((HashFunctionQuadraticProbing<T>) getHashFunction()).hash(element, probing);
				}
			}

		}
		return res;
	}
}
