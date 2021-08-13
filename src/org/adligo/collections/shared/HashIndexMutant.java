package org.adligo.collections.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Experimental this would compete with ConcurrentSkipListSet
 * @see /notes/2021-08-11-scot-heinz.txt
 *   Also it would probably take the form of two Heaps a min and max heap where
 *   the min heap elements poing to the lower bound of the lists of elements
 *   and the max heaps point to the upper bound of the lists of elements.
 *   
 * Keeps a ordered ArrayList by using the standard {@link #hashCode()} of the
 * type T. Provides a binary search {@link HashIndexMutant#search} that
 * retrieves the nearest right and left neighbors in addition to the requested
 * hash code.
 * 
 * @author scott
 *
 * @param <T>
 */
public class HashIndexMutant<T> {
	public static final String T_IS_REQUIRED = "t is required!";
	/**
	 * This list is kept in order by the hash code of the key of each element.
	 */
	private final ArrayList<T> _list = new ArrayList<>();

	public HashIndexMutant() {
	}

	public HashIndexMutant(Collection<T> items) {
		for (T t : items) {
			insert(t);
		}
	}

	public T get(int idx) {
		return _list.get(idx);
	}

	/**
	 * find a Object with a matchint hash code, if you want the closest matches use
	 * search.
	 * 
	 * Best case Ω(1), worst case O(log n).
	 * 
	 * @param t
	 * @return
	 */
	public Optional<T> find(T t) {
		return find(t.hashCode());
	}

	/**
	 * Best case Ω(1), worst case O(log n).
	 * 
	 * @param hashCode
	 * @return
	 */
	public Optional<T> find(int hashCode) {
		return null;
	}

	/**
	 * Best case Ω(1), worst case O(log n).
	 * 
	 * @param t
	 * @return the left and right eleements that surround the inserted element.
	 */
	public IndexModifiedInfo<T> insert(T t) {
		return insert(t, true);
	}

	/**
	 * Best case Ω(1), worst case O(log n).
	 * 
	 * @param t
	 * @return the left and right eleements that surround the inserted element.
	 */
	public IndexModifiedInfo<T> insertIfAbsent(T t) {
		return insert(t, false);
	}

	/**
	 * find a Object with a matchint hash code, if you want the closest matches use
	 * search.
	 * 
	 * Best case Ω(1), worst case O(log n).
	 * 
	 * @param t
	 * @return
	 */
	public IndexModifiedInfo<T> remove(T t) {
		return null;
	}

	/**
	 * Best case Ω(1), worst case O(log n).
	 * 
	 * @param hashCode
	 * @return
	 */
	public IndexModifiedInfo<T> remove(int hashCode) {
		return null;
	}

	/**
	 * See find Best case Ω(1), worst case O(log n).
	 * 
	 * @param t
	 * @return
	 */
//  public IndexSearchResult<T> search(T t) {
//  	return search(t.hashCode());
//  }

	/**
	 * Best case Ω(1), worst case O(log n).
	 * 
	 * @return
	 */
//public IndexSearchResult<T> search(int hashCode) {
////return insert(t, true);
//}

	public int size() {
		return _list.size();
	}

	public Stream<T> stream() {
		return _list.stream();
	}

	public Stream<T> streamReverse() {
		return Stream.generate(new Supplier<T>() {
			int i = _list.size() - 1;

			@Override
			public T get() {
				return _list.get(i--);
			}
		});
	}

	public List<T> subList(int fromIndex, int toIndex) {
		return _list.subList(fromIndex, toIndex);
	}

	private IndexModifiedInfo<T> insert(T t, boolean ifAbsent) {
		Objects.requireNonNull(t, T_IS_REQUIRED);
		int size = _list.size();
		switch (size) {
		case 0:
			_list.add(t);
			return new IndexModifiedInfo<T>();
		}
		// optimize for insertion of 1,2,3,4, 5 etc
		T end = _list.get(size - 1);
		int hc = t.hashCode();
		if (end.hashCode() == hc && !ifAbsent) {
			return insertReplace(size - 1, end, t);
		} else if (end.hashCode() < hc) {
			return insertEnd(t);
		}
		// or 5,4,3,2,1 etc
		T start = _list.get(0);
		if (start.hashCode() == hc && !ifAbsent) {
			return insertReplace(0, end, t);
		} else if (start.hashCode() > hc) {
			return insertFront(t);
		}
		// fall back to a binary search with recursion
		return insert(0, size - 1, t, ifAbsent);
	}

	/**
	 * A binary search with tail recursion.
	 * 
	 * @param leftIdx
	 * @param rightIdx
	 * @param keyVal
	 * @param ifAbsent
	 * @return
	 */
	private IndexModifiedInfo<T> insert(int leftIdx, int rightIdx, T keyVal, boolean ifAbsent) {
		int idxRange = leftIdx - rightIdx;
		int hc = keyVal.hashCode();
		if (idxRange <= 3) {
			// optimize for insertion of 1,2,3,4, 5 etc
			for (int i = rightIdx + 1; i >= leftIdx; i--) {
				T left = _list.get(i);
				int lHc = left.hashCode();
				if (lHc == hc && !ifAbsent) {
					return insertReplace(i, left, keyVal);
				} else if (lHc < hc) {
					return insert(i, keyVal);
				}
			}
		}
		// recurse, tail calls
		int half = (leftIdx + rightIdx);
		int hcHalf = _list.get(half).hashCode();
		if (hc == hcHalf) {
			return insertReplace(half, _list.get(half), keyVal);
		} else if (hc > hcHalf) {
			return insert(half, rightIdx, keyVal, ifAbsent);
		} else {
			return insert(leftIdx, half, keyVal, ifAbsent);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexModifiedInfo<T> insert(int idx, T keyVal) {
		_list.add(idx, keyVal);
		Optional<T> left = Optional.empty();
		if (idx >= 1) {
			left = Optional.of(_list.get(idx - 1));
		}
		Optional<T> right = Optional.of(_list.get(idx + 1));
		return new IndexModifiedInfo(Optional.empty(), left, right);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexModifiedInfo<T> insertEnd(T keyVal) {
		_list.add(keyVal);
		return new IndexModifiedInfo(Optional.empty(), Optional.of(_list.get(_list.size() - 1)), Optional.empty());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexModifiedInfo<T> insertFront(T keyVal) {
		_list.add(0, keyVal);
		return new IndexModifiedInfo(Optional.empty(), Optional.empty(), Optional.of(_list.get(1)));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IndexModifiedInfo<T> insertReplace(int idx, T toRemove, T keyVal) {
		_list.remove(idx);
		_list.add(idx, keyVal);
		return new IndexModifiedInfo(Optional.of(toRemove), Optional.empty(), Optional.of(_list.get(1)));
	}
}
