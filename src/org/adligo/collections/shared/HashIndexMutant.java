package org.adligo.collections.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class HashIndexMutant<T> {
  public static final String T_IS_REQUIRED = "t is required!";
	/**
   * This list is kept in order by the hash code of the key
   * of each element.
   */
	private final ArrayList<T> _list = new ArrayList<>();
 
  public HashIndexMutant() {}
  
  public HashIndexMutant(Collection<T> items) {
  	for (T t : items) {
  		insert(t);
  	}
  }
  
  /**
   * @param t
   * @return the left and right eleements that surround
   *   the inserted element.
   */
  public IndexInsertInfo<T> insert(T t) {
  	Objects.requireNonNull(t,T_IS_REQUIRED);
  	int size = _list.size();
  	switch (size) {
  	  case 0: _list.add(t); return new IndexInsertInfo<T>();
  	}
  	//optimize for insertion of 1,2,3,4, 5 etc
  	T end = _list.get(size -1);
  	int hc = t.hashCode();
  	if (end.hashCode() == hc) {
  		return insertReplace(size - 1, end, t);
  	} else if (end.hashCode() < hc) {
  		return insertEnd(t);
  	}
  	//or 5,4,3,2,1 etc
  	T start = _list.get(0);
  	if (start.hashCode() == hc) {
  		return insertReplace(0, end, t);
  	} else if (start.hashCode() > hc) {
  		return insertFront(t);
  	}
  	//fall back to recursion
  	return insert(0, size - 1, t);
  }
  
  private IndexInsertInfo<T> insert(int leftIdx, int rightIdx, T keyVal) {
  	int idxRange = leftIdx - rightIdx;
  	int hc = keyVal.hashCode();
  	if (idxRange <= 3) {
  		//optimize for insertion of 1,2,3,4, 5 etc   		
  		for (int i = rightIdx + 1; i >= leftIdx; i--) {
  			T left = _list.get(i);
				int lHc = left.hashCode();
				if (lHc == hc) {
					return insertReplace(i, left, keyVal);
				} else if (lHc < hc) {
					return insert(i, keyVal);
				}
  		}
  	}
  	//recurse, tail calls
  	int half = (leftIdx + rightIdx);
  	int hcHalf = _list.get(half).hashCode();
  	if (hc == hcHalf) {
  		return insertReplace(half, _list.get(half), keyVal);
  	} else if (hc > hcHalf) {
  		return insert(half, rightIdx, keyVal);
  	} else {
  		return insert(leftIdx, half, keyVal);
  	}
  }
  
  public Stream<T> stream() {
  	return _list.stream();
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexInsertInfo<T> insert(int idx, T keyVal) {
  	_list.add(idx, keyVal);
  	Optional<T> left = Optional.empty();
  	if (idx >= 1) {
  		left = Optional.of(_list.get(idx - 1));
  	}
  	Optional<T> right = Optional.of(_list.get(idx + 1));
  	return new IndexInsertInfo(Optional.empty(), left, right);
  }
  
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexInsertInfo<T> insertEnd(T keyVal) {
  	_list.add(keyVal);
  	return new IndexInsertInfo(Optional.empty(), Optional.of(_list.get(_list.size() - 1)), Optional.empty());
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexInsertInfo<T> insertFront(T keyVal) {
  	_list.add(0, keyVal);
  	return new IndexInsertInfo(Optional.empty(), Optional.empty(), Optional.of(_list.get(1)));
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexInsertInfo<T> insertReplace(int idx, T toRemove, T keyVal) {
  	_list.remove(idx);
  	_list.add(idx, keyVal);
  	return new IndexInsertInfo(Optional.of(toRemove), Optional.empty(), Optional.of(_list.get(1)));
  }
}
