package org.adligo.collections.shared;

import java.util.Objects;

/**
 * A basic immutable key value pair, although the key or value could be mutable.
 * 
 * @author scott
 *
 * @param <K>
 * @param <V>
 */
public class KeyRef<K, R> {
	public static final String A_KEY_IS_REQUIRED = "A key is required";
	public static final String A_REFERENCE_IS_REQUIRED = "A reference value (ref) is required.";
	private final K _key;
	/**
	 * Short for reference
	 */
	private final R _ref;

	public KeyRef(K key, R ref) {
		_key = Objects.requireNonNull(key, A_KEY_IS_REQUIRED);
		_ref = Objects.requireNonNull(ref, A_REFERENCE_IS_REQUIRED);
	}

	public K getKey() {
		return _key;
	}

	public R getRef() {
		return _ref;
	}

	@Override
	public int hashCode() {
		return _key.hashCode();
	}

	@Override
	public String toString() {
		return "KeyVal [" + _key + ", " + _ref + "]";
	}

}
